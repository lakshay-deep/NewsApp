package com.example.newz.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.newz.data.local.NewsDatabase
import com.example.newz.domain.model.Article
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class NewsRemoteMediator(
    private val newsDb: NewsDatabase,
    private val newsApi: NewsApi,
) : RemoteMediator<Int, Article>() {

    companion object {
        private const val START_PAGE = 0
        private val sources = listOf("bbc-news","abc-news","al-jazeera-english")
    }

    private var nextPage = START_PAGE

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Article>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.url.length / state.config.pageSize) + 1
                    }
                }
            }

            val news = newsApi.getNews(
                sources = sources.joinToString(separator = ","),
                page = loadKey
            )

//            newsDb.withTransaction {
//                if(loadType == LoadType.REFRESH) {
//                    newsDb.newsDao.delete(news.articles)
//                }
////                val newsEntities = news.articles.map { it.toArticle() }
//                newsDb.newsDao.upsert(news.articles)
//            }

            MediatorResult.Success(
                endOfPaginationReached = news.articles.isEmpty()
            )
        } catch(e: IOException) {
            MediatorResult.Error(e)
        } catch(e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
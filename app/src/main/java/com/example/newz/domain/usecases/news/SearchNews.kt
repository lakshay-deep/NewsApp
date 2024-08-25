package com.example.newz.domain.usecases.news

import androidx.paging.PagingData
import com.example.newz.domain.model.Article
import com.example.newz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources= sources
        )
    }
}
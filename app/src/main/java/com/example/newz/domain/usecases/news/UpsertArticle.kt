package com.example.newz.domain.usecases.news

import com.example.newz.data.local.NewsDao
import com.example.newz.domain.model.Article
import javax.inject.Inject

class UpsertArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        return newsDao.upsert(article= article)
    }
}
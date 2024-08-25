package com.example.newz.presentation.search

import androidx.paging.PagingData
import com.example.newz.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)
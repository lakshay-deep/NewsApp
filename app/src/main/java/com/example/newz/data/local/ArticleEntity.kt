package com.example.newz.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newz.domain.model.Source

@Entity
data class ArticleEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
)
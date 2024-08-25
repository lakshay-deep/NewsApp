package com.example.newz.data.mappers

import com.example.newz.domain.model.Article


fun Article.toArticle(): Article{
    return Article(
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = source,
        title = title,
        url= url,
        urlToImage= urlToImage
    )
}
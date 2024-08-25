package com.example.newz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newz.domain.model.Article

@Database(entities = [Article::class], version = 3,)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract val newsDao: NewsDao
}
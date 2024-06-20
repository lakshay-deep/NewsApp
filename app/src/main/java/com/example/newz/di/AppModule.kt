package com.example.newz.di

import android.app.Application
import com.example.newz.data.manager.LocalUserManagerImpl
import com.example.newz.domain.manager.LocalUserManager
import com.example.newz.domain.usecases.appEntry.AppEntryUseCases
import com.example.newz.domain.usecases.appEntry.ReadAppEntry
import com.example.newz.domain.usecases.appEntry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManager: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}
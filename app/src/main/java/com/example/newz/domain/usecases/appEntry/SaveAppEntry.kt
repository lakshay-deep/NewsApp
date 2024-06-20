package com.example.newz.domain.usecases.appEntry

import com.example.newz.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        return localUserManager.saveAppEntry()
    }
}
package com.example.newz.domain.usecases.appEntry

import com.example.newz.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        return localUserManager.saveAppEntry()
    }
}
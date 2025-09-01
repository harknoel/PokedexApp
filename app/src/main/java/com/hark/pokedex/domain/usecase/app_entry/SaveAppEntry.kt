package com.hark.pokedex.domain.usecase.app_entry

import com.hark.pokedex.domain.manager.LocalUserManager
import javax.inject.Inject


class SaveAppEntry @Inject constructor(
    private val localUserManger: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}

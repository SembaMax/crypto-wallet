package com.semba.cryptowallet.repositories.repos

import com.semba.cryptowallet.model.common.ThemeConfig
import com.semba.cryptowallet.model.common.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun setThemeConfig(newThemeConfig: ThemeConfig)
    suspend fun setCurrentWalletMnemonic(mnemonic: String)
}
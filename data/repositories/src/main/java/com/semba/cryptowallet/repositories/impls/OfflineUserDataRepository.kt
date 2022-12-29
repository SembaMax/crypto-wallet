package com.semba.cryptowallet.repositories.impls

import com.semba.cryptowallet.datastore.UserPreferencesDataSource
import com.semba.cryptowallet.model.common.ThemeConfig
import com.semba.cryptowallet.model.common.UserData
import com.semba.cryptowallet.repositories.repos.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineUserDataRepository @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource
): UserDataRepository {

    override val userData: Flow<UserData> = userPreferencesDataSource.userData

    override suspend fun setThemeConfig(newThemeConfig: ThemeConfig) {
        userPreferencesDataSource.setThemeConfig(newThemeConfig)
    }
}
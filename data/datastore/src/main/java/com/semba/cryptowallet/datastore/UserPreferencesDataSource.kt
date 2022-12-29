package com.semba.cryptowallet.datastore

import androidx.datastore.core.DataStore
import com.semba.cryptowallet.datastore.data.UserPreferences
import com.semba.cryptowallet.model.common.ThemeConfig
import com.semba.cryptowallet.model.common.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
){
    val userData = userPreferences.data.map {
        UserData(themeConfig = it.themeConfig)
    }

    suspend fun setThemeConfig(newThemeConfig: ThemeConfig) {
        userPreferences.updateData {
            it.copy(
                themeConfig = newThemeConfig
            )
        }

    }
}
package com.semba.cryptowallet.datastore.data

import com.semba.cryptowallet.model.common.ThemeConfig
import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences (
    val themeConfig: ThemeConfig = ThemeConfig.SYSTEM
)
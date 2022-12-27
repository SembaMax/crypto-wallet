package com.semba.datastore

class DataStoreDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
){

    suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        userPreferences.updateData {
            it.copy {
                this.themeConfig = when (themeConfig) {
                    ThemeConfig.FOLLOW_SYSTEM ->
                        ThemeConfigProto.THEME_CONFIG_FOLLOW_SYSTEM
                    ThemeConfig.LIGHT -> ThemeConfigProto.DARK_THEME_CONFIG_LIGHT
                    ThemeConfig.DARK -> ThemeConfigProto.DARK_THEME_CONFIG_DARK
                }
            }
        }
    }
}
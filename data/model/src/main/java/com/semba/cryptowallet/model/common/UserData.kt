package com.semba.cryptowallet.model.common

data class UserData (
    val themeConfig: ThemeConfig,
    val currentWalletIndex: Int = -1
        )
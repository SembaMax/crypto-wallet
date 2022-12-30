package com.semba.cryptowallet.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.semba.cryptowallet.ui.WalletHistoryScreenRoute

const val walletHistoryScreenRoute = "wallet_history_screen_route"

fun NavController.navigateToWalletHistoryScreen(navOptions: NavOptions? = null) {
    this.navigate(walletHistoryScreenRoute, navOptions)
}

fun NavGraphBuilder.walletHistoryScreen() {
    composable(route = walletHistoryScreenRoute) {
        WalletHistoryScreenRoute()
    }
}
package com.semba.cryptowallet.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.semba.cryptowallet.ui.MarketScreenRoute

const val marketScreenRoute = "market_screen_route"

fun NavController.navigateToMarketScreen(navOptions: NavOptions? = null) {
    this.navigate(marketScreenRoute, navOptions)
}

fun NavGraphBuilder.walletHistoryScreen() {
    composable(route = marketScreenRoute) {
        MarketScreenRoute()
    }
}
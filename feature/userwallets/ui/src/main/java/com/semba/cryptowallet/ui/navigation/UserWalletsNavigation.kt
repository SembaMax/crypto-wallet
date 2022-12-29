package com.semba.cryptowallet.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.semba.cryptowallet.ui.UserWalletsScreenRoute

const val userWalletsScreenRoute = "user_wallets_screen_route"

fun NavController.navigateToUserWalletsScreen(navOptions: NavOptions? = null) {
    this.navigate(userWalletsScreenRoute, navOptions)
}

fun NavGraphBuilder.userWalletsScreen() {
    composable(route = userWalletsScreenRoute) {
        UserWalletsScreenRoute()
    }
}
package com.semba.cryptowallet.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.semba.cryptowallet.ui.HomeScreenRoute

const val homeScreenRoute = "home_screen_route"

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeScreenRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = homeScreenRoute) {
        HomeScreenRoute(modifier = Modifier.background(MaterialTheme.colorScheme.background))
    }
}
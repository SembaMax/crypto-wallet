package com.semba.cryptowallet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.semba.cryptowallet.ui.navigation.homeScreen
import com.semba.cryptowallet.ui.navigation.homeScreenRoute

@Composable
fun CryptoWalletNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = homeScreenRoute
) {
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        homeScreen()
    }
}
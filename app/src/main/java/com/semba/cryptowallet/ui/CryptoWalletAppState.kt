package com.semba.cryptowallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.semba.cryptowallet.common.network.NetworkMonitor
import kotlinx.coroutines.CoroutineScope

@Stable
class CryptoWalletAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

}

@Composable
fun rememberCryptoWalletAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): CryptoWalletAppState {
    return remember(navController, coroutineScope, networkMonitor) {
        CryptoWalletAppState(navController, coroutineScope, networkMonitor)
    }
}
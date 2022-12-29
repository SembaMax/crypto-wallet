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
import com.semba.cryptowallet.navigation.TopLevelDestination
import com.semba.cryptowallet.ui.navigation.homeScreenRoute
import com.semba.cryptowallet.ui.navigation.userWalletsScreenRoute
import com.semba.cryptowallet.ui.navigation.walletHistoryScreenRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Stable
class CryptoWalletAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelScreen: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeScreenRoute -> TopLevelDestination.HOME
            userWalletsScreenRoute -> TopLevelDestination.USER_WALLETS
            walletHistoryScreenRoute -> TopLevelDestination.WALLET_HISTORY
            else -> null
        }

    val isOffline = networkMonitor.isOnline
        .map ( Boolean::not )
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().toList()
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
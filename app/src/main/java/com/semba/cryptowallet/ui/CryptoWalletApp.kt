package com.semba.cryptowallet.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import com.semba.cryptowallet.common.network.NetworkMonitor
import com.semba.cryptowallet.design.component.CwBackground
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.semba.cryptowallet.design.component.CwNavigationBar
import com.semba.cryptowallet.design.component.CwNavigationBarItem
import com.semba.cryptowallet.design.icon.CwIcon
import com.semba.cryptowallet.design.icon.CwIcons
import com.semba.cryptowallet.navigation.CryptoWalletNavHost
import com.semba.cryptowallet.navigation.TopLevelDestination

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CryptoWalletApp(
    networkMonitor: NetworkMonitor,
    appState: CryptoWalletAppState = rememberCryptoWalletAppState(networkMonitor = networkMonitor)
) {
    CwBackground {
        val snackHostState = remember { SnackbarHostState() }
        val isOffline by appState.isOffline.collectAsStateWithLifecycle()

        Scaffold(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(hostState = snackHostState) },
            bottomBar = {
                CwBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier
                )
            }
        )
        { padding ->
            Column(Modifier.fillMaxSize().padding(padding)) {
                CryptoWalletNavHost(
                    navController = appState.navController,
                    onBackClick = appState::onBackClick
                )
            }
        }
    }
}

@Composable
private fun CwBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    CwNavigationBar(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            CwNavigationBarItem(selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    when (destination.selectedIcon) {
                        is CwIcon.DrawableResourceIcon ->
                            Icon(
                                painter = painterResource(id = destination.selectedIcon.id),
                                contentDescription = null
                            )
                        is CwIcon.ImageVectorIcon ->
                            Icon(
                                imageVector = destination.selectedIcon.imageVector,
                                contentDescription = null
                            )
                    }
                },
                label = { Text(stringResource(id = destination.textId)) })
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
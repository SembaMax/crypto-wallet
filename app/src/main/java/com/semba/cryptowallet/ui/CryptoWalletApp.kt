package com.semba.cryptowallet.ui

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import com.semba.cryptowallet.common.network.NetworkMonitor
import com.semba.cryptowallet.design.component.CwBackground
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun CryptoWalletApp(
    networkMonitor: NetworkMonitor,
    appState: CryptoWalletAppState = rememberCryptoWalletAppState(networkMonitor = networkMonitor)
) {
    CwBackground {
        val snackHostState = remember { SnackbarHostState() }
        val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    }
}
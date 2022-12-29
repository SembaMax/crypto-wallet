package com.semba.cryptowallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.semba.cryptowallet.common.network.NetworkMonitor
import kotlinx.coroutines.CoroutineScope

@Composable
fun CryptoWalletApp(
    networkMonitor: NetworkMonitor,
    appState: CryptoWalletAppState = rememberCryptoWalletAppState(networkMonitor = networkMonitor)
) {

}
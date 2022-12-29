package com.semba.cryptowallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun WalletHistoryScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: WalletHistoryViewModel = hiltViewModel()
) {
    val WalletHistoryState by viewModel.walletHistoryUiState.collectAsStateWithLifecycle()
    WalletHistoryScreen(WalletHistoryState, modifier)
}

@Composable
fun WalletHistoryScreen(
    walletHistoryState: WalletHistoryScreenUiState,
    modifier: Modifier = Modifier
) {

}
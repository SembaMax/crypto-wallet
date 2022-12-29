package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class WalletHistoryViewModel: ViewModel() {

    val walletHistoryUiState: StateFlow<WalletHistoryScreenUiState>

}

sealed interface WalletHistoryScreenUiState {
    object Loading: WalletHistoryScreenUiState
    data class Success(val balance: String): WalletHistoryScreenUiState
}
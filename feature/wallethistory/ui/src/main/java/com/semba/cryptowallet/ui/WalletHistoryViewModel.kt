package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class WalletHistoryViewModel @Inject constructor(): ViewModel() {

    val walletHistoryUiState: StateFlow<WalletHistoryScreenUiState> = MutableStateFlow(WalletHistoryScreenUiState.Loading)

}

sealed interface WalletHistoryScreenUiState {
    object Loading: WalletHistoryScreenUiState
    data class Success(val balance: String): WalletHistoryScreenUiState
}
package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(): ViewModel() {

    val marketUiState: StateFlow<MarketScreenUiState> = MutableStateFlow(MarketScreenUiState.Loading)

}

sealed interface MarketScreenUiState {
    object Loading: MarketScreenUiState
    data class Success(val balance: String): MarketScreenUiState
}
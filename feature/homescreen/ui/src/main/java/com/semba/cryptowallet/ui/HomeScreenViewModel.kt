package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HomeScreenViewModel: ViewModel() {

    val homeUiState: StateFlow<HomeScreenUiState>

}

sealed interface HomeScreenUiState {
    object Loading: HomeScreenUiState
    data class Success(val balance: String): HomeScreenUiState
}
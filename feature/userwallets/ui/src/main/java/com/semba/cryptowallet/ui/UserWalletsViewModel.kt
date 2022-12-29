package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class UserWalletsViewModel: ViewModel() {

    val userWalletsUiState: StateFlow<UserWalletsScreenUiState>

}

sealed interface UserWalletsScreenUiState {
    object Loading: UserWalletsScreenUiState
    data class Success(val balance: String): UserWalletsScreenUiState
}
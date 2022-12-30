package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserWalletsViewModel @Inject constructor(): ViewModel() {

    val userWalletsUiState: StateFlow<UserWalletsScreenUiState> = MutableStateFlow(UserWalletsScreenUiState.Loading)

}

sealed interface UserWalletsScreenUiState {
    object Loading: UserWalletsScreenUiState
    data class Success(val balance: String): UserWalletsScreenUiState
}
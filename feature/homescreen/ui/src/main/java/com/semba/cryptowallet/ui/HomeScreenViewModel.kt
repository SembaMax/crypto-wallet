package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import com.semba.cryptowallet.repositories.repos.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val userDataRepository: UserDataRepository): ViewModel() {

    val homeUiState: StateFlow<HomeScreenUiState> = MutableStateFlow(HomeScreenUiState.Loading)

}

sealed interface HomeScreenUiState {
    object Loading: HomeScreenUiState
    data class Success(val balance: String): HomeScreenUiState
}
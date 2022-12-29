package com.semba.cryptowallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semba.cryptowallet.MainActivityUiState.Loading
import com.semba.cryptowallet.MainActivityUiState.Success
import com.semba.cryptowallet.model.common.UserData
import com.semba.cryptowallet.repositories.repos.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    userDataRepository: UserDataRepository
): ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
        Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = Loading,
        started = SharingStarted.WhileSubscribed(5_000)
    )
}

sealed interface MainActivityUiState {
    object Loading: MainActivityUiState
    data class Success(val userData: UserData): MainActivityUiState
}
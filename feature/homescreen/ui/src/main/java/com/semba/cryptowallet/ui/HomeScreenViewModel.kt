package com.semba.cryptowallet.ui

import androidx.lifecycle.ViewModel
import com.semba.cryptowallet.model.wallet.WalletCurrency
import com.semba.cryptowallet.repositories.repos.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val userDataRepository: UserDataRepository): ViewModel() {

    val homeUiState: StateFlow<HomeScreenUiState> = MutableStateFlow(HomeScreenUiState.Success("0", currencies = initCurrenciesList()))

    fun initCurrenciesList(): List<CurrencyItem> {
        val list = mutableListOf<CurrencyItem>()
        WalletCurrency.values().forEach {
            list.add(CurrencyItem(it.iconRes, it.name, "0"))
        }
        return list
    }
}

sealed interface HomeScreenUiState {
    object Loading: HomeScreenUiState
    data class Success(val balanceInUSD: String, val currencies: List<CurrencyItem>): HomeScreenUiState
}

data class CurrencyItem (
    val iconRes: Int,
    val currencyName: String,
    val balance: String
        )
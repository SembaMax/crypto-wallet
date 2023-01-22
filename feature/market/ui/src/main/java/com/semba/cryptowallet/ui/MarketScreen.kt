package com.semba.cryptowallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MarketScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: MarketViewModel = hiltViewModel()
) {
    val marketUiState by viewModel.marketUiState.collectAsStateWithLifecycle()
    MarketScreen(marketUiState, modifier)
}

@Composable
fun MarketScreen(
    marketState: MarketScreenUiState,
    modifier: Modifier = Modifier
) {

}
package com.semba.cryptowallet.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreenRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val homeState by viewModel.homeUiState.collectAsStateWithLifecycle()
    HomeScreen(homeState, modifier)
}

@Composable
fun HomeScreen(
    homeState: HomeScreenUiState,
    modifier: Modifier = Modifier
) {

}
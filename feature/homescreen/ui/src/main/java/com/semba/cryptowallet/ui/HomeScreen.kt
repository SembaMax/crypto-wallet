package com.semba.cryptowallet.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.semba.cryptowallet.design.component.LoadingIndicator

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
    when (homeState) {
        HomeScreenUiState.Loading -> LoadingState()
        is HomeScreenUiState.Success -> HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent()
{
    Column(modifier = Modifier.fillMaxSize()) {

    }
}

@Composable
fun LoadingState(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        LoadingIndicator()
    }
}
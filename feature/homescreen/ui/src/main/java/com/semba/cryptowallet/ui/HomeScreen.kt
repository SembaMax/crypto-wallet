package com.semba.cryptowallet.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.semba.cryptowallet.design.component.LoadingIndicator
import com.semba.cryptowallet.ui.theme.*
import com.semba.cryptowallet.feature.homescreen.ui.R as R

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
        is HomeScreenUiState.Success -> HomeScreenContent(homeState)
    }
}

@Composable
fun HomeScreenContent(state: HomeScreenUiState.Success)
{
    Column(modifier = Modifier.fillMaxSize()) {
        BalanceSection(state.balanceInUSD)
        TransferSection()
        CurrencySection(state.currencies)
    }
}

@Composable
fun BalanceSection(balanceInUSD : String = "0") {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 30.dp), contentAlignment = Alignment.Center)
    {
        Canvas(modifier = Modifier.size(300.dp)) {
            drawArc(color = BalanceArcStroke, startAngle = -215f, sweepAngle = 250f, useCenter = false, style = Stroke(width = 20f, cap = StrokeCap.Round))
        }

        Text(text = "$balanceInUSD $", fontSize = 35.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CurrencySection(rows: List<CurrencyBalance>) {
    LazyColumn() {
        items(rows.size) {
            Row(modifier = Modifier.fillMaxWidth().height(70.dp).padding(horizontal = 20.dp, vertical = 5.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(CurrencyItemBackground),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
                Text(text = rows[it].currencyName, color = ButtonTextColor)
                Text(text = rows[it].balance, color = ButtonTextColor)
            }
        }
    }
}

@Composable
fun TransferSection() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {

        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .padding(horizontal = 10.dp, 15.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(ButtonBackground)) {
            Text(text = stringResource(id = R.string.send_currency), color = ButtonTextColor)
        }

        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .padding(horizontal = 10.dp, 15.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .background(ButtonBackground)) {
            Text(text = stringResource(id = R.string.receive_currency), color = ButtonTextColor)
        }
    }
}

@Composable
fun LoadingState(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        LoadingIndicator()
    }
}
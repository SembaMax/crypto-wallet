package com.semba.cryptowallet.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.semba.cryptowallet.design.component.LoadingIndicator
import com.semba.cryptowallet.ui.theme.*
import com.semba.cryptowallet.feature.homescreen.ui.R as R
import com.semba.cryptowallet.core.design.R as DesignR

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
        is HomeScreenUiState.Success -> HomeScreenContent(modifier, homeState)
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier, state: HomeScreenUiState.Success)
{
    Column(modifier = modifier.fillMaxSize()) {
        BalanceSection(state.balanceInUSD)
        TransferSection()
        Spacer(modifier = Modifier.height(20.dp))
        CurrencySection(state.currencies)
    }
}

@Composable
fun BalanceSection(balanceInUSD : String = "0") {
    val arcColor = MaterialTheme.colorScheme.secondary

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 30.dp), contentAlignment = Alignment.Center)
    {
        Canvas(modifier = Modifier.size(300.dp)) {
            drawArc(color = arcColor, startAngle = -215f, sweepAngle = 250f, useCenter = false, style = Stroke(width = 20f, cap = StrokeCap.Round))
        }

        Text(text = "$balanceInUSD $", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}

@Composable
fun CurrencySection(rows: List<CurrencyItem>) {

    LazyColumn() {
        items(rows.size) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(CurrencyItemBackground),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier.padding(start = 10.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = rows[it].iconRes), contentDescription = null, modifier = Modifier.size(30.dp), tint= Color.Unspecified)
                    Text(text = rows[it].currencyName, color = Color.Black, modifier = Modifier.padding(start = 5.dp))
                }
                Text(text = rows[it].balance, color = Color.Black, modifier = Modifier.padding(end = 10.dp))
            }
        }
    }
}

@Composable
fun TransferSection() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {

        Button(modifier = Modifier
            .defaultMinSize(minWidth = 80.dp)
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .border(1.5.dp, color = Color.White, shape = RoundedCornerShape(10.dp)),
            onClick = {}
            ) {
            Icon(painter = painterResource(id = DesignR.drawable.ic_send), contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            Text(text = stringResource(id = R.string.send_currency), color = Color.White)
        }

        Button( modifier = Modifier
            .defaultMinSize(minWidth = 80.dp)
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .border(1.5.dp, color = Color.White, shape = RoundedCornerShape(10.dp)),
            onClick = {}
            ) {
            Icon(painter = painterResource(id = DesignR.drawable.ic_receive), contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
            Text(text = stringResource(id = R.string.receive_currency), color = Color.White)
        }
    }
}

@Composable
fun LoadingState(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        LoadingIndicator()
    }
}
package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrency_cleanarchitecture.presentation.coin_list.components.ComposeCoinItem
import com.example.cryptocurrency_cleanarchitecture.presentation.commons.ComposeLoadingScreen

@Composable
fun ComposeCoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state by viewModel.state

    if (state.loading) {
        ComposeLoadingScreen()
    }

    if (state.coins.isNotEmpty()) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(state.coins.count()) {
                ComposeCoinItem(coin = state.coins[it]) { coin ->
                    navController.navigate("coins/${coin.id}")
                }
            }
        }
    }
}
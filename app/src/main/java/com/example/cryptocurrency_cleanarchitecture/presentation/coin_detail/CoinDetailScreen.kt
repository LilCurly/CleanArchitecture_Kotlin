package com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrency_cleanarchitecture.presentation.commons.ComposeLoadingScreen

@Composable
fun ComposeCoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.loading) {
            ComposeLoadingScreen()
        }

        if (state.coinDetail != null) {
            Text("Got a response!")
        }

        if (state.error.isNotEmpty()) {
            Text(state.error)
        }
    }
}
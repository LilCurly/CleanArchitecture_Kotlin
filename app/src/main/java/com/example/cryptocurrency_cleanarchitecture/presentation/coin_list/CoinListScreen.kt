package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ComposeCoinListScreen(
    viewModel: CoinListViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val state by viewModel.state
        if (state.loading) {
            CircularProgressIndicator()
        }

        if (state.coins.isNotEmpty()) {
            Text(text = "It works!")
        }

        if (state.error.isNotEmpty()) {
            Text(text = state.error)
        }
    }
}
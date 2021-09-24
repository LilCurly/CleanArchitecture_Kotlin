package com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail.components.ComposeTagItem
import com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail.components.ComposeTeamMemberItem
import com.example.cryptocurrency_cleanarchitecture.presentation.commons.ComposeErrorScreen
import com.example.cryptocurrency_cleanarchitecture.presentation.commons.ComposeLoadingScreen
import com.example.cryptocurrency_cleanarchitecture.presentation.theme.DividerColor
import com.example.cryptocurrency_cleanarchitecture.presentation.theme.OnBackground
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ComposeCoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state

    if (state.loading) {
        ComposeLoadingScreen()
    }

    if (state.error.isNotEmpty()) {
        ComposeErrorScreen(state.error)
    }

    state.coinDetail?.let { coinDetail ->
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                ) {
                    Text(
                        text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
                        fontSize = 22.sp,
                        color = OnBackground
                    )
                    Text(
                        text = if (coinDetail.isActive) "active" else "inactive",
                        color = if (coinDetail.isActive) Color.Green else Color.Red,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            item {
                Text(
                    coinDetail.description,
                    color = OnBackground,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
            item {
                Text(
                    "Tags",
                    color = OnBackground,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
            item {
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                ) {
                    coinDetail.tags.forEach {
                        ComposeTagItem(it)
                    }
                }
            }
            item {
                Text(
                    "Team members",
                    color = OnBackground,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
            items(coinDetail.team) {
                ComposeTeamMemberItem(it)
                Divider(color = DividerColor)
            }
        }
    }
}
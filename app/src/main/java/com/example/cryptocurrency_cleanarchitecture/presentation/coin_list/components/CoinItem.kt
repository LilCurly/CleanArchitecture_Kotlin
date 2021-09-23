package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrency_cleanarchitecture.entities.Coin

@Composable
fun ComposeCoinItem(coin: Coin, onItemClick: (Coin) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(coin)
            }
            .padding(15.dp)
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            color = MaterialTheme.colors.onBackground,
        )
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
        )
    }
}
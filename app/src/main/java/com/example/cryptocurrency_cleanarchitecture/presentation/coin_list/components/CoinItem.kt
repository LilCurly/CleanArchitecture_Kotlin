package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import com.example.cryptocurrency_cleanarchitecture.entities.Coin

@Composable
fun ComposeCoinItem(coin: Coin) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "${coin.id}. ${coin.name} (${coin.symbol}")
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic
        )
    }
}
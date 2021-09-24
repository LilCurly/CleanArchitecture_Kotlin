package com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cryptocurrency_cleanarchitecture.entities.Tag

@Composable
fun ComposeTagItem(tag: Tag) {
    Card(
        elevation = 0.dp,
        shape = CircleShape,
        backgroundColor = Color.Transparent,
        border = BorderStroke(1.dp, Color.Green)
    ) {
        Text(
            tag.name,
            color = Color.Green,
            modifier = Modifier.padding(10.dp)
        )
    }
}
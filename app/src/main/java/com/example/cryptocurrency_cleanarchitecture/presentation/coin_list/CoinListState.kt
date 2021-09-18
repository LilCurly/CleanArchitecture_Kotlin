package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list

import com.example.cryptocurrency_cleanarchitecture.entities.Coin

data class CoinListState(
    val loading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)
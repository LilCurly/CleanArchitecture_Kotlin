package com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail

import com.example.cryptocurrency_cleanarchitecture.entities.CoinDetail

data class CoinDetailState(
    val loading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
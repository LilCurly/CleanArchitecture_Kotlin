package com.example.cryptocurrency_cleanarchitecture.data

import com.example.cryptocurrency_cleanarchitecture.domain.CoinDetail

interface CoinDetailDataSource {
    suspend fun getById(coinId: String): CoinDetail?
}
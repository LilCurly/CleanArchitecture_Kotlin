package com.example.cryptocurrency_cleanarchitecture.data

import com.example.cryptocurrency_cleanarchitecture.domain.Coin

interface CoinDataSource {
    suspend fun getAll(): List<Coin>
    suspend fun getByName(coinName: String): Coin?
}
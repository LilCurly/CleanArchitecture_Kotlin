package com.example.cryptocurrency_cleanarchitecture.repositories

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import kotlinx.coroutines.flow.Flow

interface CoinDetailRepository {
    fun getById(coinId: String): Flow<Result<Coin>>
}
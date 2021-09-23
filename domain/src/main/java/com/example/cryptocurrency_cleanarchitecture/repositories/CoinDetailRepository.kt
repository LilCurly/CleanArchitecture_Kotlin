package com.example.cryptocurrency_cleanarchitecture.repositories

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.entities.CoinDetail
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CoinDetailRepository {
    fun getById(coinId: String): Flow<Resource<CoinDetail>>
}
package com.example.cryptocurrency_cleanarchitecture.repositories

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getAll(): Flow<Resource<List<Coin>>>
    fun getByName(coinName: String): Flow<Resource<Coin>>
}
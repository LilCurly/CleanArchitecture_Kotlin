package com.example.cryptocurrency_cleanarchitecture.data

import javax.inject.Inject

class CoinRepository @Inject constructor(private val dataSource: CoinDataSource) {
    suspend fun getAll() = dataSource.getAll()
    suspend fun getByName(coinName: String) = dataSource.getByName(coinName)
}
package com.example.cryptocurrency_cleanarchitecture.data

class CoinRepository(private val dataSource: CoinDataSource) {
    suspend fun getAll() = dataSource.getAll()
    suspend fun getByName(coinName: String) = dataSource.getByName(coinName)
}
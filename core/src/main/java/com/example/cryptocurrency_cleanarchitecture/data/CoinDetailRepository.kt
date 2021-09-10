package com.example.cryptocurrency_cleanarchitecture.data

class CoinDetailRepository(private val dataSource: CoinDetailDataSource) {
    suspend fun getById(coinId: String) = dataSource.getById(coinId)
}
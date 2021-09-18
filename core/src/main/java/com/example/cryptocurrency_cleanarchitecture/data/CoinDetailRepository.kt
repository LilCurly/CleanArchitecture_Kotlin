package com.example.cryptocurrency_cleanarchitecture.data

import javax.inject.Inject

class CoinDetailRepository @Inject constructor(private val dataSource: CoinDetailDataSource) {
    suspend fun getById(coinId: String) = dataSource.getById(coinId)
}
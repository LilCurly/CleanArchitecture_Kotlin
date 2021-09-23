package com.example.cryptocurrency_cleanarchitecture.network.sources

import com.example.cryptocurrency_cleanarchitecture.entities.CoinDetail
import com.example.cryptocurrency_cleanarchitecture.network.mappers.CoinDetailMapper
import com.example.cryptocurrency_cleanarchitecture.network.services.CoinService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinDetailRemoteDataSource @Inject constructor(
    private val service: CoinService,
    private val mapper: CoinDetailMapper
) {
    suspend fun getCoinById(coinId: String): CoinDetail {
        return mapper.mapToEntity(service.getCoinById(coinId))
    }
}
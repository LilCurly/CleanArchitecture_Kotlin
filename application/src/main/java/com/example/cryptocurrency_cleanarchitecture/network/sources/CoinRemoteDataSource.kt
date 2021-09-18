package com.example.cryptocurrency_cleanarchitecture.network.sources

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.network.mappers.CoinMapper
import com.example.cryptocurrency_cleanarchitecture.network.services.CoinService

class CoinRemoteDataSource (
    private val service: CoinService,
    private val mapper: CoinMapper
) {
    suspend fun getCoins(): List<Coin> {
        return service.getCoins().map {
            mapper.mapToEntity(it)
        }
    }

    suspend fun getCoinByName(coinName: String): Coin {
        return mapper.mapToEntity(service.getCoinByName(coinName))
    }
}
package com.example.cryptocurrency_cleanarchitecture.network.services

import com.example.cryptocurrency_cleanarchitecture.network.models.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinName}")
    suspend fun getCoinByName(@Path("") coinName: String): CoinDto
}
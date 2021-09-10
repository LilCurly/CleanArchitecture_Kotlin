package com.example.cryptocurrency_cleanarchitecture.interactors.coin.request

import com.example.cryptocurrency_cleanarchitecture.data.CoinRepository

class GetCoinByName(private val coinRepository: CoinRepository) {
    suspend operator fun invoke(coinName: String) = coinRepository.getByName(coinName)
}
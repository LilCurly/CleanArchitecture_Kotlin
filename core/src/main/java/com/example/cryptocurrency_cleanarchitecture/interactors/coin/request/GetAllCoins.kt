package com.example.cryptocurrency_cleanarchitecture.interactors.coin.request

import com.example.cryptocurrency_cleanarchitecture.data.CoinRepository

class GetAllCoins(private val coinRepository: CoinRepository) {
    suspend operator fun invoke() = coinRepository.getAll()
}
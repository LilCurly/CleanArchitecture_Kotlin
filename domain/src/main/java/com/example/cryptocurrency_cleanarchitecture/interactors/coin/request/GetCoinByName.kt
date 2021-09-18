package com.example.cryptocurrency_cleanarchitecture.interactors.coin.request

import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepository

class GetCoinByName (private val repository: CoinRepository) {
    operator fun invoke(coinName: String) = repository.getByName(coinName)
}
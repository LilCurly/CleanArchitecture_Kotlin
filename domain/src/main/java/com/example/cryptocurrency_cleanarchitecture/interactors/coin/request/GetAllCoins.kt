package com.example.cryptocurrency_cleanarchitecture.interactors.coin.request

import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepository

class GetAllCoins (private val repository: CoinRepository) {
    operator fun invoke() = repository.getAll()
}
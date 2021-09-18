package com.example.cryptocurrency_cleanarchitecture.interactors.coin_detail.request

import com.example.cryptocurrency_cleanarchitecture.repositories.CoinDetailRepository

class GetCoinDetailById (private val repository: CoinDetailRepository) {
    operator fun invoke(coinId: String) = repository.getById(coinId)
}
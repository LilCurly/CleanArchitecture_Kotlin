package com.example.cryptocurrency_cleanarchitecture.interactors.coin_detail.request

import com.example.cryptocurrency_cleanarchitecture.repositories.CoinDetailRepository
import javax.inject.Inject

class GetCoinDetailById @Inject constructor(private val repository: CoinDetailRepository) {
    operator fun invoke(coinId: String) = repository.getById(coinId)
}
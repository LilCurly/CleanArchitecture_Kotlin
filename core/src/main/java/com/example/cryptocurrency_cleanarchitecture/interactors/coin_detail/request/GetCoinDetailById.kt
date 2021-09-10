package com.example.cryptocurrency_cleanarchitecture.interactors.coin_detail.request

import com.example.cryptocurrency_cleanarchitecture.data.CoinDetailRepository

class GetCoinDetailById(private val coinDetailRepository: CoinDetailRepository) {
    suspend operator fun invoke(coinId: String) = coinDetailRepository.getById(coinId)
}
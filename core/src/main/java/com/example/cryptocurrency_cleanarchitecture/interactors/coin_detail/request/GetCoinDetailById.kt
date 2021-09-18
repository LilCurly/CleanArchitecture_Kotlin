package com.example.cryptocurrency_cleanarchitecture.interactors.coin_detail.request

import com.example.cryptocurrency_cleanarchitecture.data.CoinDetailRepository
import javax.inject.Inject

class GetCoinDetailById @Inject constructor(private val coinDetailRepository: CoinDetailRepository) {
    suspend operator fun invoke(coinId: String) = coinDetailRepository.getById(coinId)
}
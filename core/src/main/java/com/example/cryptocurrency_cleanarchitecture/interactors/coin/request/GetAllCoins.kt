package com.example.cryptocurrency_cleanarchitecture.interactors.coin.request

import com.example.cryptocurrency_cleanarchitecture.data.CoinRepository
import javax.inject.Inject

class GetAllCoins @Inject constructor(private val coinRepository: CoinRepository) {
    suspend operator fun invoke() = coinRepository.getAll()
}
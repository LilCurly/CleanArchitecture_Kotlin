package com.example.cryptocurrency_cleanarchitecture.interactors.coin.request

import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepository
import javax.inject.Inject

class GetAllCoins @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke() = repository.getAll()
}
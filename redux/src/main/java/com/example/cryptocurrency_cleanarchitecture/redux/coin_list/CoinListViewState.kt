package com.example.cryptocurrency_cleanarchitecture.redux.coin_list

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.redux.State
import javax.inject.Inject

data class CoinListViewState(
    val isLoading: Boolean,
    val error: String?,
    val coins: List<Coin>?
): State {
    @Inject constructor(): this(true, null, null)
}

package com.example.cryptocurrency_cleanarchitecture.redux.coin_list

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.redux.Action
import javax.inject.Inject

sealed class CoinListAction: Action {
    object RequestingCoinList: CoinListAction()
    object LoadingCoinList: CoinListAction()
    data class LoadingFailed(val error: String): CoinListAction()
    data class LoadingCompleted(val coins: List<Coin>): CoinListAction()
    data class CoinClicked(val coinId: String): CoinListAction()
}

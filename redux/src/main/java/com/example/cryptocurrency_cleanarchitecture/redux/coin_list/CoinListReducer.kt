package com.example.cryptocurrency_cleanarchitecture.redux.coin_list

import com.example.cryptocurrency_cleanarchitecture.redux.Reducer
import javax.inject.Inject

class CoinListReducer @Inject constructor(): Reducer<CoinListAction, CoinListViewState> {
    override fun reduce(
        previousState: CoinListViewState,
        currentAction: CoinListAction
    ): CoinListViewState {
        return when(currentAction) {
            is CoinListAction.LoadingCoinList -> {
               previousState.copy(isLoading = true)
            }
            is CoinListAction.LoadingFailed -> {
                previousState.copy(error = currentAction.error, isLoading = false)
            }
            is CoinListAction.LoadingCompleted -> {
                previousState.copy(coins = currentAction.coins, isLoading = false)
            }
            else -> previousState
        }
    }
}
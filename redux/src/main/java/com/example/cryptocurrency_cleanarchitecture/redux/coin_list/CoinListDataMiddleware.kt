package com.example.cryptocurrency_cleanarchitecture.redux.coin_list

import com.example.cryptocurrency_cleanarchitecture.interactors.coin.request.GetAllCoins
import com.example.cryptocurrency_cleanarchitecture.redux.Middleware
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CoinListDataMiddleware @Inject constructor(val getAllCoinsUseCase: GetAllCoins): Middleware<CoinListAction, CoinListViewState> {

    @ExperimentalCoroutinesApi
    override suspend fun process(
        currentState: CoinListViewState,
        action: CoinListAction,
        coroutineScope: CoroutineScope
    ): Flow<CoinListAction> = channelFlow {
        when(action) {
            is CoinListAction.RequestingCoinList -> {
                getAllCoinsUseCase().onEach {
                    when(it.status) {
                        Resource.Status.LOADING -> send(CoinListAction.LoadingCoinList)
                        Resource.Status.ERROR -> {
                            send(
                                CoinListAction.LoadingFailed(
                                    it.message ?: "An unexpected error occured"
                                )
                            )
                            close()
                        }
                        Resource.Status.SUCCESS -> {
                            send(
                                CoinListAction.LoadingCompleted(it.data ?: emptyList())
                            )
                            close()
                        }
                    }
                }.launchIn(coroutineScope)
            }
        }
        awaitClose()
    }
}
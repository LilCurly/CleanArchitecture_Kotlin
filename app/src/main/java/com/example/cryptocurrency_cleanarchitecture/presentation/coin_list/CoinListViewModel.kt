package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency_cleanarchitecture.redux.Store
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListAction
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListDataMiddleware
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListReducer
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val store: Store<CoinListViewState, CoinListAction>): ViewModel() {

    val state: StateFlow<CoinListViewState> = store.state

    init {
        getCoins()
    }

    private fun getCoins() {
        val action = CoinListAction.RequestingCoinList

        viewModelScope.launch {
            store.dispatch(action, this)
        }
    }
}
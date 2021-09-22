package com.example.cryptocurrency_cleanarchitecture.presentation.coin_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency_cleanarchitecture.interactors.coin.request.GetAllCoins
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetAllCoins): ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach {
            when (it.status) {
                Resource.Status.ERROR -> {
                    _state.value = CoinListState(error = it.message ?: "An unexpected error occured")
                }
                Resource.Status.LOADING -> {
                    _state.value = CoinListState(loading = true)
                }
                Resource.Status.SUCCESS -> {
                    _state.value = CoinListState(coins = it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}
package com.example.cryptocurrency_cleanarchitecture.presentation.coin_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency_cleanarchitecture.interactors.coin_detail.request.GetCoinDetailById
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getByIdUseCase: GetCoinDetailById,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state = _state

    init {
        savedStateHandle.get<String>("coinId")?.let {
            getCoinDetail(it)
        }
    }

    fun getCoinDetail(coinId: String) {
        getByIdUseCase(coinId).onEach {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    _state.value = CoinDetailState(coinDetail = it.data)
                }
                Resource.Status.LOADING -> {
                    _state.value = CoinDetailState(loading = true)
                }
                Resource.Status.ERROR -> {
                    _state.value = CoinDetailState(error = it.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }
}
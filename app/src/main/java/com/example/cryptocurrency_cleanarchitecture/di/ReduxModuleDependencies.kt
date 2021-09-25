package com.example.cryptocurrency_cleanarchitecture.di

import com.example.cryptocurrency_cleanarchitecture.presentation.coin_list.CoinListState
import com.example.cryptocurrency_cleanarchitecture.redux.Middleware
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListAction
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListReducer
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListViewState
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ReduxModuleDependencies {
    /*fun coinListReducer(reducer: CoinListReducer)
    fun coinListMiddlewares(middlewares: List<Middleware<CoinListAction, CoinListViewState>>)*/
}
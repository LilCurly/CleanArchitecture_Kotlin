package com.example.cryptocurrency_cleanarchitecture.di

import com.example.cryptocurrency_cleanarchitecture.commons.Constants
import com.example.cryptocurrency_cleanarchitecture.interactors.coin.request.GetAllCoins
import com.example.cryptocurrency_cleanarchitecture.network.services.CoinService
import com.example.cryptocurrency_cleanarchitecture.presentation.coin_list.CoinListState
import com.example.cryptocurrency_cleanarchitecture.redux.Middleware
import com.example.cryptocurrency_cleanarchitecture.redux.Reducer
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListAction
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListDataMiddleware
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListReducer
import com.example.cryptocurrency_cleanarchitecture.redux.coin_list.CoinListViewState
import com.example.cryptocurrency_cleanarchitecture.repositories.CoinDetailRepository
import com.example.cryptocurrency_cleanarchitecture.repositories.CoinDetailRepositoryImpl
import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepository
import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [ApplicationModule.RepositoriesModule::class])
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    // QUALIFIERS

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CoinListStore

    // SERVICES

    @Provides
    @Singleton
    fun provideCoinService(): CoinService {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinService::class.java)
    }

    // MIDDLEWARES

    @Provides
    @Singleton
    fun provideCoinListMiddlewares(getAllCoins: GetAllCoins): List<Middleware<CoinListAction, CoinListViewState>> {
        return listOf(CoinListDataMiddleware(getAllCoins))
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoriesModule {

        // REPOSITORIES

        @Binds
        @Singleton
        fun bindCoinRepository(
            coinRepositoryImpl: CoinRepositoryImpl
        ): CoinRepository

        @Binds
        @Singleton
        fun bindCoinDetailRepository(
            coinDetailRepositoryImpl: CoinDetailRepositoryImpl
        ): CoinDetailRepository

        // REDUCERS

        @Binds
        @Singleton
        fun bindCoinListReducer(
            coinListReducer: CoinListReducer
        ): Reducer<CoinListAction, CoinListViewState>
    }
}
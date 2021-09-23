package com.example.cryptocurrency_cleanarchitecture.di

import com.example.cryptocurrency_cleanarchitecture.cache.sources.CoinCacheDataSource
import com.example.cryptocurrency_cleanarchitecture.commons.Constants
import com.example.cryptocurrency_cleanarchitecture.network.mappers.CoinMapper
import com.example.cryptocurrency_cleanarchitecture.network.services.CoinService
import com.example.cryptocurrency_cleanarchitecture.network.sources.CoinRemoteDataSource
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
import javax.inject.Singleton

@Module(includes = [ApplicationModule.RepositoriesModule::class])
@InstallIn(SingletonComponent::class)
class ApplicationModule {

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
    }
}
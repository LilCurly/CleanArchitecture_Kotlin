package com.example.cryptocurrency_cleanarchitecture.repositories

import com.example.cryptocurrency_cleanarchitecture.cache.sources.CoinCacheDataSource
import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.network.sources.CoinRemoteDataSource
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val remoteSource: CoinRemoteDataSource,
    private val cacheSource: CoinCacheDataSource,
): CoinRepository {
    override fun getAll(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.loading(null))
            val coins = remoteSource.getCoins()
            emit(Resource.success(coins))
        } catch (e: HttpException) {
            emit(Resource.error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.error<List<Coin>>("You seem to be disconnected."))
        }
    }

    override fun getByName(coinName: String): Flow<Resource<Coin>> = flow {
        try {
            emit(Resource.loading(null))
            val coin = remoteSource.getCoinByName(coinName)
            emit(Resource.success(coin))
        } catch (e: HttpException) {
            emit(Resource.error<Coin>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.error<Coin>("You seem to be disconnected."))
        }
    }
}
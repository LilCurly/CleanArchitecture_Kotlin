package com.example.cryptocurrency_cleanarchitecture.repositories

import com.example.cryptocurrency_cleanarchitecture.cache.sources.CoinDetailCacheDataSource
import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.entities.CoinDetail
import com.example.cryptocurrency_cleanarchitecture.network.sources.CoinDetailRemoteDataSource
import com.example.cryptocurrency_cleanarchitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: CoinDetailRemoteDataSource,
    private val cacheDataSource: CoinDetailCacheDataSource
): CoinDetailRepository {
    override fun getById(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.loading(null))
            val coinDetail = remoteDataSource.getCoinById(coinId)
            emit(Resource.success(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.error<CoinDetail>("You seem to be disconnected."))
        }
    }

}
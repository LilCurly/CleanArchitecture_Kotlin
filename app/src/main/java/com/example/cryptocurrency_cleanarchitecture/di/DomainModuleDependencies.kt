package com.example.cryptocurrency_cleanarchitecture.di

import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepository
import com.example.cryptocurrency_cleanarchitecture.repositories.CoinRepositoryImpl
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DomainModuleDependencies {
    fun coinRepository(coinRepositoryImpl: CoinRepositoryImpl)
}
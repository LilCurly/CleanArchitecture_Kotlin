package com.example.cryptocurrency_cleanarchitecture.network.mappers

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.mappers.Mapper
import com.example.cryptocurrency_cleanarchitecture.network.models.CoinDto
import javax.inject.Inject

class CoinMapper @Inject constructor(): Mapper<CoinDto, Coin> {
    override fun mapToEntity(model: CoinDto): Coin {
        return Coin(
            model.id ?: "",
            model.rank ?: 0,
            model.name ?: "",
            model.symbol ?: "",
            model.isActive ?: false
        )
    }

    override fun mapFromEntity(entity: Coin): CoinDto {
        return CoinDto(
            entity.id,
            entity.isActive,
            null,
            entity.name,
            entity.rank,
            entity.symbol,
            null
        )
    }
}
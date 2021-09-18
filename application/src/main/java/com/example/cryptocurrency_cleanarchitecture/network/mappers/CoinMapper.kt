package com.example.cryptocurrency_cleanarchitecture.network.mappers

import com.example.cryptocurrency_cleanarchitecture.entities.Coin
import com.example.cryptocurrency_cleanarchitecture.mappers.Mapper
import com.example.cryptocurrency_cleanarchitecture.network.models.CoinDto

class CoinMapper: Mapper<CoinDto, Coin> {
    override fun mapToEntity(model: CoinDto): Coin {
        return Coin(
            model.id ?: "",
            model.name ?: "",
            model.symbol ?: "",
        )
    }

    override fun mapFromEntity(entity: Coin): CoinDto {
        return CoinDto(
            entity.id,
            null,
            null,
            entity.name,
            null,
            entity.symbol,
            null
        )
    }
}
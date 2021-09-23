package com.example.cryptocurrency_cleanarchitecture.network.mappers

import com.example.cryptocurrency_cleanarchitecture.entities.CoinDetail
import com.example.cryptocurrency_cleanarchitecture.entities.Tag
import com.example.cryptocurrency_cleanarchitecture.entities.TeamMember
import com.example.cryptocurrency_cleanarchitecture.mappers.Mapper
import com.example.cryptocurrency_cleanarchitecture.network.models.CoinDetailDto
import com.example.cryptocurrency_cleanarchitecture.network.models.TagDto
import com.example.cryptocurrency_cleanarchitecture.network.models.TeamMemberDto
import javax.inject.Inject

class CoinDetailMapper @Inject constructor(): Mapper<CoinDetailDto, CoinDetail> {
    override fun mapToEntity(model: CoinDetailDto): CoinDetail {
        return CoinDetail(
            model.id ?: "",
            model.name ?: "",
            model.symbol ?: "",
            model.description ?: "",
            model.proofType ?: "",
            model.tags?.map {
                Tag(
                    it.name ?: "",
                )
            } ?: emptyList(),
            model.team?.map {
                TeamMember(
                    it.name ?: "",
                    it.position ?: "",
                )
            } ?: emptyList()
        )
    }

    override fun mapFromEntity(entity: CoinDetail): CoinDetailDto {
        return CoinDetailDto(
            entity.description,
            null,
            null,
            null,
            null,
            entity.id,
            null,
            null,
            null,
            null,
            null,
            null,
            entity.name,
            null,
            null,
            entity.proofType,
            null,
            null,
            entity.symbol,
            entity.tags.map {
                TagDto(
                    null,
                    null,
                    null,
                    it.name
                )
            },
            entity.team.map {
                TeamMemberDto(
                    null,
                    it.name,
                    it.position,
                )
            },
            null,
            null
        )
    }
}
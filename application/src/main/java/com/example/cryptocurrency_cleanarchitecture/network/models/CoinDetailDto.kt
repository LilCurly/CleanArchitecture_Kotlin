package com.example.cryptocurrency_cleanarchitecture.network.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinDetailDto(
    @Json(name = "description")
    val description: String?,
    @Json(name = "development_status")
    val developmentStatus: String?,
    @Json(name = "first_data_at")
    val firstDataAt: String?,
    @Json(name = "hardware_wallet")
    val hardwareWallet: Boolean?,
    @Json(name = "hash_algorithm")
    val hashAlgorithm: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "is_active")
    val isActive: Boolean?,
    @Json(name = "is_new")
    val isNew: Boolean?,
    @Json(name = "last_data_at")
    val lastDataAt: String?,
    @Json(name = "links")
    val links: LinksDto?,
    @Json(name = "links_extended")
    val linksExtended: List<LinksExtendedDto>?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "open_source")
    val openSource: Boolean?,
    @Json(name = "org_structure")
    val orgStructure: String?,
    @Json(name = "proof_type")
    val proofType: String?,
    @Json(name = "rank")
    val rank: Int?,
    @Json(name = "started_at")
    val startedAt: String?,
    @Json(name = "symbol")
    val symbol: String?,
    @Json(name = "tags")
    val tags: List<TagDto>?,
    @Json(name = "team")
    val team: List<TeamMemberDto>?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "whitepaper")
    val whitepaper: WhitepaperDto?
)
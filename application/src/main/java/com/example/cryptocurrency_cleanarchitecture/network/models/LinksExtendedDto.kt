package com.example.cryptocurrency_cleanarchitecture.network.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksExtendedDto(
    @Json(name = "stats")
    val stats: StatsDto?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?
)
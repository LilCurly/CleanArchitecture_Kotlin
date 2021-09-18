package com.example.cryptocurrency_cleanarchitecture.network.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatsDto(
    @Json(name = "contributors")
    val contributors: Int?,
    @Json(name = "followers")
    val followers: Int?,
    @Json(name = "stars")
    val stars: Int?,
    @Json(name = "subscribers")
    val subscribers: Int?
)
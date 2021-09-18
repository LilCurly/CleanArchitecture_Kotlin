package com.example.cryptocurrency_cleanarchitecture.network.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WhitepaperDto(
    @Json(name = "link")
    val link: String?,
    @Json(name = "thumbnail")
    val thumbnail: String?
)
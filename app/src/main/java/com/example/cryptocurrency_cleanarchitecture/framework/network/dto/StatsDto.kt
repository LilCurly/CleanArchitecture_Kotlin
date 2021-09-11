package com.example.cryptocurrency_cleanarchitecture.framework.network.dto


import com.google.gson.annotations.SerializedName

data class StatsDto(
    val contributors: Int?,
    val followers: Int?,
    val stars: Int?,
    val subscribers: Int?
)
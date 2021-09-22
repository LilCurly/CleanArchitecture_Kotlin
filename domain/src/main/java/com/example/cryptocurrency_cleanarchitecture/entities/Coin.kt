package com.example.cryptocurrency_cleanarchitecture.entities

data class Coin(
    var id: String,
    var rank: Int,
    var name: String,
    var symbol: String,
    var isActive: Boolean,
)

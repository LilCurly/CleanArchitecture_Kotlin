package com.example.cryptocurrency_cleanarchitecture.entities

data class CoinDetail(
    var id: String,
    var rank: Int,
    var name: String,
    var symbol: String,
    var description: String,
    var proofType: String,
    var tags: List<Tag>,
    var team: List<TeamMember>,
    var isActive: Boolean
)

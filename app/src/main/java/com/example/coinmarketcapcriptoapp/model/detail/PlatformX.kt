package com.example.coinmarketcapcriptoapp.model.detail


import com.google.gson.annotations.SerializedName

data class PlatformX(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("token_address")
    val tokenAddress: String?
)
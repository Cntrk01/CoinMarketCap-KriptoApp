package com.example.coinmarketcapcriptoapp.model.home


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD")
    val uSD: USD?
)
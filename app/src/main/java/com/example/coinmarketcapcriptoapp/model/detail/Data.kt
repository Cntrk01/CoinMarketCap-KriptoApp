package com.example.coinmarketcapcriptoapp.model.detail


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ETH")
    val eTH: List<CoinDetail>?
)
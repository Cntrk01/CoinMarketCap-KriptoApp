package com.example.coinmarketcapcriptoapp.model.errorResponse


import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status")
    val status: Status?
)
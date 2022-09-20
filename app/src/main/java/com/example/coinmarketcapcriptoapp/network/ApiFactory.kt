package com.example.coinmarketcapcriptoapp.network

import com.example.coinmarketcapcriptoapp.model.detail.DetailResponse
import com.example.coinmarketcapcriptoapp.model.home.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiFactory {
    //https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?limit=10
    //CMC_PRO_API_KEY a72653a8-d11d-4560-8e0e-9954a3e5d757
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getData(
        @Header("X-CMC_PRO_API_KEY") apiKey:String,
        @Query("limit")limit:String
    ):CryptoResponse

    @GET("v2/cryptocurrency/info")
    suspend fun getDetail(
        @Header("X-CMC_PRO_API_KEY")apiKey: String,
        @Query("symbol") symbol:String
    ):DetailResponse
}
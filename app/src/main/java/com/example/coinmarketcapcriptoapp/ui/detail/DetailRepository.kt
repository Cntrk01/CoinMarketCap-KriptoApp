package com.example.coinmarketcapcriptoapp.ui.detail

import com.example.coinmarketcapcriptoapp.base.BaseRepository
import com.example.coinmarketcapcriptoapp.network.ApiFactory
import javax.inject.Inject

class DetailRepository @Inject constructor(private val apiFactory: ApiFactory):BaseRepository() {

    suspend fun getDetail(apiKey:String,symbol:String)=safeRequest {
        apiFactory.getDetail(apiKey,symbol)
    }
}
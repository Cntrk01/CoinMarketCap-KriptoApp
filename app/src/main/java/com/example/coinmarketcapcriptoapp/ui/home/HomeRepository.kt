package com.example.coinmarketcapcriptoapp.ui.home

import com.example.coinmarketcapcriptoapp.base.BaseRepository
import com.example.coinmarketcapcriptoapp.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject
 constructor(private val apiFactory: ApiFactory):BaseRepository(){

    suspend fun getData(apiKey:String,limit:String)=safeRequest {
        apiFactory.getData(apiKey,limit)
    }
 }
package com.example.coinmarketcapcriptoapp.utils

sealed class NetworkResult<T>(
    val data:T?=null,
    val message:String?=null,
    val networkError:Boolean=false
){
    class Succes<T>(data: T?):NetworkResult<T>(data)
    class Error<T>(networkError: Boolean,message: String?):NetworkResult<T>(data = null,message=message,networkError=networkError)


}

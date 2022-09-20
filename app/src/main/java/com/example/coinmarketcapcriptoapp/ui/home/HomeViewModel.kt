package com.example.coinmarketcapcriptoapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinmarketcapcriptoapp.model.home.CryptoResponse
import com.example.coinmarketcapcriptoapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor(private val repository: HomeRepository):ViewModel() {
    val cryptoResponse:MutableLiveData<CryptoResponse?> = MutableLiveData()
    val isLoading:MutableLiveData<Boolean> = MutableLiveData(true)
    val onError : MutableLiveData<String?> = MutableLiveData()
    fun getData(apiKey:String,limit:String)=viewModelScope.launch {
        isLoading.value=true
        val request=repository.getData(apiKey,limit)
//        Dilersek  cryptoResponse.value=request.data yerine bu şekilde post yaparak da veriyi yazabiliriz
//        request.let {
//            cryptoResponse.postValue(it.data)
//        }
        when(request){
            is NetworkResult.Succes -> {
                cryptoResponse.value=request.data
                isLoading.value=false
            }
            is NetworkResult.Error -> {
                onError.value=request.message
                isLoading.value = false
            }
        }
    }
}
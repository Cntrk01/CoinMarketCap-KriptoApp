package com.example.coinmarketcapcriptoapp.di


import com.example.coinmarketcapcriptoapp.BuildConfig
import com.example.coinmarketcapcriptoapp.network.ApiFactory
import com.example.coinmarketcapcriptoapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModul {
    @Singleton
    @Provides
    fun provideHttpLoggerIntercaptor():HttpLoggingInterceptor{
        val httpLoggingInterceptor=HttpLoggingInterceptor()
        if(BuildConfig.DEBUG){
            httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        }else httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }
    @Singleton
    @Provides
    //parametreyi otomatik yukarıdaki fonksiyondan alcak
    fun provideHttpClient(httpLoggingInterceptor:HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder().readTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor)
            .build()
    }
    @Singleton
    @Provides
    fun provideConventerFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient).addConverterFactory(gsonConverterFactory).build()
    }
    @Singleton
    @Provides
    fun provideApiFactory(retrofit: Retrofit):ApiFactory{
        return retrofit.create(ApiFactory::class.java)
    }
}
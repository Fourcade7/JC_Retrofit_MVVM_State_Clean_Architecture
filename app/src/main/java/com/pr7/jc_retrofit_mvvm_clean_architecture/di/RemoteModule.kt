package com.pr7.jc_retrofit_mvvm_clean_architecture.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.pr7.jc_retrofit_mvvm_clean_architecture.data.source.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {


    @[Provides Singleton]
    fun provideOkHTTPClient(@ApplicationContext context: Context): OkHttpClient {
        val okHttpClient=OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context)).build()
        return okHttpClient

    }

    @[Provides Named("PostsRetrofit")]
    fun providePostRetrofit(client:OkHttpClient):Retrofit{
        val retrofit=Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    @Provides
    fun provdieApi(@Named("PostsRetrofit") retrofit: Retrofit):Api{
        val api=retrofit.create(Api::class.java)
        return api
    }

}
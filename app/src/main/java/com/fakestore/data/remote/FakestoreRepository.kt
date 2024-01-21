package com.fakestore.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FakestoreRepository {

    const val BASE_URL = "https://fakestoreapi.com"

    private val retrofit: Retrofit = getInstance()
    val fakestoreApi: FakestoreApiInterface = retrofit.create(FakestoreApiInterface::class.java)

    fun getInstance(): Retrofit {
        val mHttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient =
            OkHttpClient.Builder().addInterceptor(mHttpLoggingInterceptor).build()

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(mOkHttpClient).build()
    }
}
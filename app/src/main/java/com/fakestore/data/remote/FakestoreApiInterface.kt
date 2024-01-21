package com.fakestore.data.remote

import com.fakestore.data.remote.model.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//  TODO params
interface FakestoreApiInterface {

    // @GET("/products/5")
    // suspend fun getTestResponse(): Response<ResponseProduct>

    @GET("/products/{productId}")

    suspend fun getTestResponse(@Path("productId") productId: String): Response<ResponseProduct>
}
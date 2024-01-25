package com.fakestore.data.remote

import com.fakestore.data.remote.model.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//  TODO params
interface FakestoreApiInterface {

    // @GET("/products")
    // suspend fun getAllProducts(): Response<ResponseAllProducts>

    // @GET("/products/5")
    // suspend fun getTestResponse(): Response<ResponseProduct>
    @GET("/products/{productId}")
    suspend fun getProduct(@Path("productId") productId: String): Response<ResponseProduct>

    @GET("/products/categories")
    // TODO спросить про класс
//    suspend fun getCategories(): Response<ResponseCategories>
    suspend fun getCategories(): Response<List<String>>

    // GET
    // /products/category/jewelery
    // GET
    // /carts?userId=1
    // GET
    // /products?limit=5
// TODO

}
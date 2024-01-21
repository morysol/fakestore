package com.fakestore.data.remote.model

import com.google.gson.annotations.SerializedName


data class ResponseProduct(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("price")
    var price: String?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("image")
    var imageURL: String?,
    @SerializedName("rating")
    val rating: Rating?
)

data class Rating(
    @SerializedName("rate")
    val rate: Double?,
    @SerializedName("count")
    val count: Int?
)
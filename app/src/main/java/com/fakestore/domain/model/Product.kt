package com.fakestore.domain.model

data class Product(
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val imageURL: String,
    val rate: Double,
    val count: Int
)
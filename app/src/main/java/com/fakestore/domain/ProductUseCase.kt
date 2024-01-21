package com.fakestore.domain

import com.fakestore.domain.model.Product

interface ProductUseCase {
    suspend fun getProduct(): Product
}
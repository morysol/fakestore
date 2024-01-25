package com.fakestore.domain


import com.fakestore.domain.model.Categories

interface CategoriesUseCase {
    suspend fun getCategories(): Categories
}
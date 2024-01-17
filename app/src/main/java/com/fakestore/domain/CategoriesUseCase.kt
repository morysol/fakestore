package com.fakestore.domain

import com.fakestore.data.remote.FakestoreRepository
import com.fakestore.domain.model.Categories
import retrofit2.Response

object CategoriesUseCase {
    suspend fun getCategories(): Categories {
        val repo = FakestoreRepository
        val categoriesFromRepo = repo.fakestoreApi.getCategories()
        return convertCategories(categoriesFromRepo)

    }

    private fun convertCategories(categories: Response<List<String>>): Categories {
        return Categories(categories.body() ?: listOf())
    }
}
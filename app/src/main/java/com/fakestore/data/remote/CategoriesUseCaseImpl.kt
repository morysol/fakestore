package com.fakestore.data.remote

import com.fakestore.domain.CategoriesUseCase
import com.fakestore.domain.model.Categories
import retrofit2.Response

open class CategoriesUseCaseImpl : CategoriesUseCase {

    override suspend fun getCategories(): Categories {
        val repo = FakestoreRepository
        val categoriesFromRepo = repo.fakestoreApi.getCategories()
        return convertCategories(categoriesFromRepo)

    }

    private fun convertCategories(categories: Response<List<String>>): Categories {
        return Categories(categories.body() ?: listOf())
    }
}
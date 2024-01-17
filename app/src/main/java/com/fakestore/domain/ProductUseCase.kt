package com.fakestore.domain

import com.fakestore.data.remote.FakestoreRepository
import com.fakestore.data.remote.model.ResponseProduct
import com.fakestore.domain.model.Product
import retrofit2.Response

object ProductUseCase {

    suspend fun getProduct(): Product {
        val repo = FakestoreRepository
        // val retrofit = repo.getInstance()
        //  val apiInterface = retrofit.create(FakestoreApiInterface::class.java)

        val productFromRepo = repo.fakestoreApi.getProduct("14")
        // val productFromRepo = apiInterface.getTestResponse("14")
        //  val productFromRepo = repo.getTestResponse("14")
        return convertProduct(productFromRepo)
    }

    private fun convertProduct(productFromRepo: Response<ResponseProduct>): Product {
        val id = productFromRepo.body()?.id ?: 0
        val title = productFromRepo.body()?.title ?: "unknown"
        val price = productFromRepo.body()?.price ?: "unknown"
        val category = productFromRepo.body()?.category ?: "unknown"
        val imageURL = productFromRepo.body()?.imageURL ?: "unknown"
        val rate = productFromRepo.body()?.rating?.rate ?: 0.0
        val count = productFromRepo.body()?.rating?.count ?: 0

        return Product(id, title, price, category, imageURL, rate, count)
    }

}
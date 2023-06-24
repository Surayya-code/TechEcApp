package com.example.techecapp.service

import com.example.techecapp.modul.category.CategoryResponse
import com.example.techecapp.modul.product.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface Service {
   @GET("products")
   fun getProducts():Call<ProductResponse>

    @GET("categories")
    fun getCategories():Call<CategoryResponse>

}
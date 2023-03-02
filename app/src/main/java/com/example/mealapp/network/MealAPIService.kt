package com.example.mealapp.network

import com.example.mealapp.models.MealBase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// base url
private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

// moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// api call
interface MealAPIService {
    @GET("search.php")
    suspend fun getMealsByLetter(@Query("f") letter: String): MealBase
}

// api object
object MealApi {
    val retrofitService : MealAPIService by lazy { retrofit.create(MealAPIService::class.java) }
}

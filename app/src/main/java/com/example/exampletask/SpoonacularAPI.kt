package com.example.exampletask

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface SpoonacularAPI {

    companion object {

        private const val BASE_URL = "https://api.spoonacular.com/"
        private var api: SpoonacularAPI? = null

        fun getInstance() : SpoonacularAPI {
            if (api == null) {
                val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create(SpoonacularAPI::class.java)
            }
            return api!!
        }
    }

    @GET("recipes/search")
    suspend fun searchRecipes(
        @Query("apiKey") apiKey: String = SpoonacularConstants.API_KEY,
        @Query("query") query: String = SpoonacularConstants.QUERY,
        @Query("offset") offset: Int = SpoonacularConstants.OFFSET,
        @Query("number") number: Int = SpoonacularConstants.NUMBER
    ): RecipesResult

}

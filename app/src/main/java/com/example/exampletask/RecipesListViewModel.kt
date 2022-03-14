package com.example.exampletask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesListViewModel: ViewModel() {

    val recipesResult = MutableLiveData<RecipesResult>()
    val errorMessage = MutableLiveData<String>()

    fun getRecipesList() {
        val response = SpoonacularAPI.getInstance().getRecipes()
        response.enqueue(object : Callback<RecipesResult> {
            override fun onResponse(call: Call<RecipesResult>, response: Response<RecipesResult>) {
                recipesResult.postValue(response.body())
            }
            override fun onFailure(call: Call<RecipesResult>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}

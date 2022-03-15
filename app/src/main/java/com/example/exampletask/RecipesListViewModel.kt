package com.example.exampletask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesListViewModel : ViewModel() {
    var page = 1
    val searchRecipeUseCase = SearchRecipeUseCase(SpoonacularRepo(SpoonacularAPI.getInstance()))

    val recipesList = MutableLiveData<List<Recipe>>()
    val errorMessage = MutableLiveData<String>()

    fun searchRecipe(isPaginate: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            searchRecipeUseCase(SearchRecipeUseCase.Param(offset = page))
                .catch { e ->
                    errorMessage.postValue(e.localizedMessage)
                }.collectIn(viewModelScope) { pair ->
                    pair.first.let { recipesList.postValue(it) }
                }
        }
    }

}

package com.example.exampletask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exampletask.usecase.DeleteSavedRecipeUseCase
import com.example.exampletask.usecase.SaveRecipeUseCase
import com.example.exampletask.usecase.SearchRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
open class RecipesListViewModel @Inject constructor(
    val saveRecipeUseCase: SaveRecipeUseCase,
    val searchRecipeUseCase: SearchRecipeUseCase,
    val deleteSavedRecipe: DeleteSavedRecipeUseCase
) : ViewModel() {
    var page = 1
    val recipesList = MutableLiveData<List<Recipe>>()
    val errorMessage = MutableLiveData<String>()

    private fun saveRecipe(recipe: Recipe) =
        saveRecipeUseCase(SaveRecipeUseCase.Param(recipe))
            .collectIn(viewModelScope) {
                //TODO:
            }

    fun searchRecipe(isPaginate: Boolean = false) {
        searchRecipeUseCase(SearchRecipeUseCase.Param(offset = page))
            .catch { e ->
                errorMessage.postValue(e.localizedMessage)
            }.collectIn(viewModelScope) { pair ->
                val recipes = pair.first
                recipesList.postValue(recipes)
                recipes.forEach { saveRecipe(it) }

            }
    }

}

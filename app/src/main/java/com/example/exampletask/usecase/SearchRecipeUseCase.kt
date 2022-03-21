package com.example.exampletask.usecase

import com.example.exampletask.Recipe
import com.example.exampletask.SpoonacularRepo
import com.example.exampletask.UseCase
import com.example.exampletask.database.SpoonacularLocalRepo

class SearchRecipeUseCase(
    var repo: SpoonacularRepo,
    var localRepo: SpoonacularLocalRepo
) :
    UseCase.FlowUseCase<Pair<List<Recipe>, Boolean>, SearchRecipeUseCase.Param>() {

    override suspend fun run(params: Param): Pair<List<Recipe>, Boolean> {

        val response = repo.searchRecipeFor(number = params.number, offset = params.offset)
        val savedList = localRepo.getAllSavedRecipes().map { it.id }
        val recipeList = response.results.map {
            Recipe(
                it.id,
                it.title,
                it.readyInMinutes,
                it.servings,
                response.baseURI + it.image,
                isSaved = savedList.contains(it.id)
            )
        }
        val endOfList = params.number * params.offset >= response.totalResults

        return Pair(recipeList, endOfList)
    }

    data class Param(
        var number: Int = 10,
        var offset: Int = 0
    )
}

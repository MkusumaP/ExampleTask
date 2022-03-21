package com.example.exampletask.usecase

import com.example.exampletask.Recipe
import com.example.exampletask.UseCase
import com.example.exampletask.database.SpoonacularLocalRepo
import com.example.exampletask.database.mapToRecipeEntity

class SaveRecipeUseCase(var localRepository: SpoonacularLocalRepo) :
    UseCase.FlowUseCase<Long, SaveRecipeUseCase.Param>() {
    override suspend fun run(params: Param): Long {
        val localRecipe = mapToRecipeEntity(params.recipe)
        return localRepository.insertRecipe(localRecipe)
    }

    data class Param(var recipe: Recipe)
}

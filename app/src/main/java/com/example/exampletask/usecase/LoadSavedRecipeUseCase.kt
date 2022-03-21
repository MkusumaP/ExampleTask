package com.example.exampletask.usecase

import com.example.exampletask.Recipe
import com.example.exampletask.UseCase
import com.example.exampletask.database.SpoonacularLocalRepo
import com.example.exampletask.database.toRecipe

class LoadSavedRecipeUseCase(var localRepository: SpoonacularLocalRepo): UseCase.FlowUseCase<List<Recipe>, UseCase.None>() {

    override suspend fun run(params: UseCase.None): List<Recipe> {
        return localRepository.getAllSavedRecipes().map{
            it.toRecipe(true)
        }
    }
}
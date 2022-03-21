package com.example.exampletask.usecase

import com.example.exampletask.UseCase
import com.example.exampletask.database.SpoonacularLocalRepo

class DeleteSavedRecipeUseCase(val localRepository: SpoonacularLocalRepo) : UseCase.FlowUseCase<Int, Int>() {
    override suspend fun run(params: Int): Int {
        return localRepository.deleteRecipes(params)
    }
}

package com.example.exampletask

class SearchRecipeUseCase(var repo: SpoonacularRepo) :
    UseCase.FlowUseCase<Pair<List<Recipe>, Boolean>, SearchRecipeUseCase.Param>() {

    override suspend fun run(params: Param): Pair<List<Recipe>, Boolean> {

        val response = repo.searchRecipeFor(number = params.number, offset = params.offset)
        val recipeList = response.results.map {
            Recipe(
                it.id,
                it.title,
                it.readyInMinutes,
                it.servings,
                it.sourceURL,
                it.openLicense,
                response.baseURI + it.image
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

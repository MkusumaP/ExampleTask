package com.example.exampletask


import java.lang.Exception

class SpoonacularRepo(val api: SpoonacularAPI) {

    suspend fun searchRecipeFor(
        query: String = SpoonacularConstants.QUERY,
        number: Int = SpoonacularConstants.NUMBER,
        offset: Int = SpoonacularConstants.OFFSET
    ) : RecipesResult = run {
        api.searchRecipes(query = query, number = number, offset = offset)
    }

    suspend fun <T> run(invoker: suspend () -> T): T{

        try {
            return invoker.invoke()
        } catch (e: Exception){
            e.printStackTrace()
            throw e
        }
    }

}
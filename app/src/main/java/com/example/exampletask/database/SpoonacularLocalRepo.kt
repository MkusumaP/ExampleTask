package com.example.exampletask.database


import com.example.exampletask.Recipe
import kotlinx.coroutines.flow.Flow

class SpoonacularLocalRepo(var recipeDao: RecipeDao) {

    suspend fun getAllSavedRecipes(): List<LocalRecipe> = recipeDao.getAllSavedRecipe()

    suspend fun isSaved(recipeId: Int) = recipeDao.isSavedRecipe(recipeId) > 0

    fun getSavedRecipesCount(): Flow<Long> = recipeDao.getTotalSavedRecipes()

    suspend fun deleteRecipes(id: Int) = recipeDao.deleteRecipe(id)

    /**
     * Insert recipe to database
     * @return
     * row_number -> if the insert is sucessfull
     * -1 -> if the recipe already exist
     */
    suspend fun insertRecipe(recipe: LocalRecipe): Long =
        recipeDao.insertRecipe(recipe)
}

fun mapToRecipeEntity(recipe: Recipe) = LocalRecipe(
    recipe.id,
    recipe.image,
    recipe.readyInMinutes,
    recipe.servings,
    recipe.title
)

fun LocalRecipe.toRecipe(isSaved: Boolean = false): Recipe {
    return Recipe(id, title, servings, readyInMinutes, imageUrl, isSaved)
}

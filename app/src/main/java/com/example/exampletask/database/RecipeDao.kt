package com.example.exampletask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class RecipeDao {
    @Query("SELECT * from local_recipe ORDER BY id ASC")

    abstract suspend fun getAllSavedRecipe(): List<LocalRecipe>

    @Query("SELECT count(id) from local_recipe where id = :id")
    abstract suspend fun isSavedRecipe(id: Int): Int

    @Query("SELECT count(id) from local_recipe")
    abstract fun getSavedRecipesCount(): Flow<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertRecipe(recipe: LocalRecipe): Long

    @Query("DELETE FROM local_recipe WHERE id = :id")
    abstract suspend fun deleteRecipe(id: Int): Int

    fun getTotalSavedRecipes(): Flow<Long> = getSavedRecipesCount().distinctUntilChanged()

}
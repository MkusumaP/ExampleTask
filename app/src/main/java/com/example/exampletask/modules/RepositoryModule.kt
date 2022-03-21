package com.example.exampletask.modules

import com.example.exampletask.SpoonacularAPI
import com.example.exampletask.SpoonacularRepo
import com.example.exampletask.database.RecipeDao
import com.example.exampletask.database.SpoonacularLocalRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun getRemoteRepository(apiService: SpoonacularAPI) = SpoonacularRepo(apiService)

    @Provides
    fun getLocalRepository(recipeDao: RecipeDao) = SpoonacularLocalRepo(recipeDao)
}

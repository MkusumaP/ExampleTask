package com.example.exampletask.modules

import com.example.exampletask.RecipesListViewModel
import com.example.exampletask.usecase.DeleteSavedRecipeUseCase
import com.example.exampletask.usecase.SaveRecipeUseCase
import com.example.exampletask.usecase.SearchRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    @Provides
    fun getRecipesListViewModel(
        saveRecipeUseCase: SaveRecipeUseCase,
        searchRecipeUseCase: SearchRecipeUseCase,
        deleteSavedRecipe: DeleteSavedRecipeUseCase
    ) = RecipesListViewModel(saveRecipeUseCase, searchRecipeUseCase, deleteSavedRecipe)
}

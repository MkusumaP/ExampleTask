package com.example.exampletask.modules

import com.example.exampletask.SpoonacularRepo
import com.example.exampletask.database.SpoonacularLocalRepo
import com.example.exampletask.usecase.DeleteSavedRecipeUseCase
import com.example.exampletask.usecase.LoadSavedRecipeUseCase
import com.example.exampletask.usecase.SaveRecipeUseCase
import com.example.exampletask.usecase.SearchRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun getSearchRecipeUseCase(
        repository: SpoonacularRepo,
        localRepository: SpoonacularLocalRepo
    ) = SearchRecipeUseCase(repository, localRepository)

    @Provides
    fun getSaveRecipeUseCase(localRepository: SpoonacularLocalRepo) =
        SaveRecipeUseCase(localRepository)

    @Provides
    fun getLoadSavedRecipeUseCase(localRepository: SpoonacularLocalRepo) =
        LoadSavedRecipeUseCase(localRepository = localRepository)

    @Provides
    fun deleteSavedRecipeUseCase(localRepository: SpoonacularLocalRepo) =
        DeleteSavedRecipeUseCase(localRepository = localRepository)


}

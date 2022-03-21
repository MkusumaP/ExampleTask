package com.example.exampletask.modules

import com.example.exampletask.SpoonacularAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun getSpoonacularApiService() = SpoonacularAPI.getInstance()
}

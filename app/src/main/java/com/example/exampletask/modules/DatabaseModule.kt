package com.example.exampletask.modules

import android.content.Context
import androidx.room.Room
import com.example.exampletask.database.RecipeDatabase
import com.example.exampletask.database.RecipeDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): RecipeDatabase {
        return Room.databaseBuilder(
            appContext,
            RecipeDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideRecipeDatasource(database: RecipeDatabase) = database.recipeDao()
}

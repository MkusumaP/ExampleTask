package com.example.exampletask.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_recipe")
class LocalRecipe(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "image")
    val imageUrl: String,

    @ColumnInfo(name = "cooking_time")
    val readyInMinutes: Int,

    @ColumnInfo(name = "servings")
    val servings: Int,

    @ColumnInfo(name = "title")
    val title: String
)

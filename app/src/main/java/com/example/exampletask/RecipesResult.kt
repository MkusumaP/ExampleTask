package com.example.exampletask

import com.google.gson.annotations.SerializedName

data class RecipesResult(
    val results: List<Recipe>,

    @SerializedName(value = "baseUri")
    val baseURI: String,

    val offset: Long,
    val number: Long,
    val totalResults: Long,

    @SerializedName(value = "processingTimeMs")
    val processingTimeMS: Long,

    val expires: Long,
    val isStale: Boolean
)

data class Recipe (
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val image: String,
    val isSaved: Boolean
)




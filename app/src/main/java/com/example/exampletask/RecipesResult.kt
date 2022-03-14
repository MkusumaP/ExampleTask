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
    val id: Long,
    val title: String,
    val readyInMinutes: Long,
    val servings: Long,

    @SerializedName(value = "sourceUrl")
    val sourceURL: String,

    val openLicense: Long,
    val image: String
)


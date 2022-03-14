package com.example.exampletask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampletask.databinding.ListItemRecipesBinding

class RecipesListAdapter: RecyclerView.Adapter<RecipeItemViewHolder>() {

    private var recipesResult: RecipesResult? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(recipesResult: RecipesResult) {
        this.recipesResult = recipesResult
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemRecipesBinding.inflate(inflater, parent, false)
        return RecipeItemViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val recipeBaseURI = recipesResult?.baseURI ?: return
        val recipe = recipesResult?.results?.get(position) ?: return

        val imageUrl = recipeBaseURI + recipe.image
        Glide.with(holder.itemView.context).load(imageUrl).into(holder.binding.recipeImageView)

        holder.binding.recipeNameTextView.text = recipe.title
        holder.binding.recipeDescriptionTextView.text = "Servings: ${recipe.servings}, Ready In: ${recipe.readyInMinutes} minutes"
    }

    override fun getItemCount(): Int {
        return recipesResult?.results?.count() ?: 0
    }
}
class RecipeItemViewHolder(val binding: ListItemRecipesBinding) : RecyclerView.ViewHolder(binding.root) {
}

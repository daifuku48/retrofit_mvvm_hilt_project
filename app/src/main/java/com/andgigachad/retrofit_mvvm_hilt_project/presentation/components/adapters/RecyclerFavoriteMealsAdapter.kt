package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.data.database.entities.RecipeEntity
import com.bumptech.glide.Glide

class RecyclerFavoriteMealsAdapter(private val dataSet : List<RecipeEntity>) :
    RecyclerView.Adapter<RecyclerFavoriteMealsAdapter.ViewHolder>() {

    var onItemClick: ((RecipeEntity) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mealsImage: ImageView
        val mealsName: TextView

        init{
            mealsImage = itemView.findViewById(R.id.recipeImage)
            mealsName = itemView.findViewById(R.id.recipeName)
            itemView.setOnClickListener {
                onItemClick?.invoke(dataSet[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_meal_item, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataSet[position]
                .strMealThumb)
            .skipMemoryCache(true)
            .circleCrop()
            .into(holder.mealsImage)

        holder.mealsName.text = dataSet[position].strMeal
    }
}
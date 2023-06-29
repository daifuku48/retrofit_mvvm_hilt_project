package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Meal
import com.bumptech.glide.Glide

class RecyclerMealsAdapter(private val dataSet : List<Meal>) :
    RecyclerView.Adapter<RecyclerMealsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mealsImage: ImageView
        val mealsName: TextView

        init{
            mealsImage = itemView.findViewById(R.id.mealsImage)
            mealsName = itemView.findViewById(R.id.mealsName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.meals_item, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataSet[position]
                .strMealThumb)
            .skipMemoryCache(true)
            .into(holder.mealsImage)

        holder.mealsName.text = dataSet[position].strMeal
    }
}
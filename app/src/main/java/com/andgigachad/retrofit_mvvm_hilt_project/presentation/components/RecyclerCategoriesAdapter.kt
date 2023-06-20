package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.CategoriesDomain
import com.bumptech.glide.Glide

class RecyclerCategoriesAdapter(private val dataList: CategoriesDomain) : RecyclerView.Adapter<RecyclerCategoriesAdapter.ViewHolder>()  {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recipeImage : ImageView
        var recipeName : TextView
        var recipeDetail : TextView
        init{
            recipeImage = itemView.findViewById(R.id.recipeImage)
            recipeName = itemView.findViewById(R.id.recipeName)
            recipeDetail = itemView.findViewById(R.id.recipeDetail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataList.categories[position]
                .strCategoryThumb)
            .into(holder.recipeImage)
        holder.recipeName.text = dataList.categories[position].strCategory
        holder.recipeDetail.text = dataList.categories[position].strCategoryDescription
    }

}
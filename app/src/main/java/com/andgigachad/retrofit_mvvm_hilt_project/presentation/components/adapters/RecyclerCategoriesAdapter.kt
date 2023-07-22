package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Category
import com.bumptech.glide.Glide

class RecyclerCategoriesAdapter(private val dataList: List<Category>) : RecyclerView.Adapter<RecyclerCategoriesAdapter.ViewHolder>()  {

    var onItemClick: ((Category) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recipeImage : ImageView
        var recipeName : TextView
        var recipeDetail : TextView
        init{
            recipeImage = itemView.findViewById(R.id.recipeImage)
            recipeName = itemView.findViewById(R.id.recipeName)
            recipeDetail = itemView.findViewById(R.id.recipeDetail)
            itemView.setOnClickListener {
                onItemClick?.invoke(dataList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataList[position]
                .strCategoryThumb)
            .skipMemoryCache(true)
            .into(holder.recipeImage)
        holder.recipeName.text = dataList[position].strCategory
        holder.recipeDetail.text = dataList[position].strCategoryDescription
    }

}
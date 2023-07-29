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

class RecyclerCategoriesAdapter(private val dataSet : List<Category>) :
    RecyclerView.Adapter<RecyclerCategoriesAdapter.ViewHolder>() {

    var onItemClick: ((Category) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val categoryImage: ImageView
        val categoryName: TextView
        val categoryDescription : TextView
        init{
            categoryImage = itemView.findViewById(R.id.recipeImage)
            categoryName = itemView.findViewById(R.id.recipeName)
            categoryDescription = itemView.findViewById(R.id.recipeDetail)
            itemView.setOnClickListener {
                onItemClick?.invoke(dataSet[absoluteAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCategoriesAdapter.ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataSet[position]
                .strCategoryThumb)
            .skipMemoryCache(true)
            .circleCrop()
            .into(holder.categoryImage)

        holder.categoryName.text = dataSet[position].strCategory
        holder.categoryDescription.text = dataSet[position].strCategoryDescription
    }

    override fun getItemCount() = dataSet.size

}

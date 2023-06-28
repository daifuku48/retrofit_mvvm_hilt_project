package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.MealsDomain
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.Meal

class RecyclerMealsAdapter(val dataSet : MealsDomain) :
    RecyclerView.Adapter<RecyclerMealsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
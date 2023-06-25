package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentMealByCategoriesBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MealByCategoriesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MealsByCategoriesFragment : Fragment() {

    private var _binding : FragmentMealByCategoriesBinding? = null
    private val binding
        get() = _binding

    private val vm : MealByCategoriesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealByCategoriesBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
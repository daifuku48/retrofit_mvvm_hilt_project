package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentRecipeOfMealBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.RecipeOfMealViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.SharedViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi



class RecipeOfMealFragment : Fragment() {

    val sharedVM : SharedViewModel by activityViewModels()
    val vm : RecipeOfMealViewModel by viewModels()
    private var _binding : FragmentRecipeOfMealBinding? = null
    private val binding
            get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeOfMealBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
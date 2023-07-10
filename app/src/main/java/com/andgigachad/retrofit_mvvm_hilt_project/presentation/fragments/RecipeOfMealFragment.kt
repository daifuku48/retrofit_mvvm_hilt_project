package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentRecipeOfMealBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.RecipeOfMealViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.SharedViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@AndroidEntryPoint
class RecipeOfMealFragment : Fragment() {
    private val navController by lazy { findNavController() }
    private val sharedVM : SharedViewModel by activityViewModels()
    private val vm : RecipeOfMealViewModel by viewModels()
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
        sharedVM.getMealName().observe(viewLifecycleOwner){ mealName ->
            if (mealName != null)
            {
                vm.fetchData(mealName)
                binding?.mealName?.text = mealName
            }
        }

        vm.mealsList.observe(viewLifecycleOwner){ meal ->
            if (meal != null){
                _binding?.mealImage?.let {
                    Glide.with(requireContext())
                        .load(meal.strMealThumb)
                        .skipMemoryCache(true)
                        .centerCrop()
                        .into(it)
                }
                _binding?.textInstructions?.text = meal.strInstructions
                _binding?.mealIngredientsAndMeasure?.text = vm.textIngredientsAndMeasure
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
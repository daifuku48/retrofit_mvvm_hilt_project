package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentRecipeOfMealBinding
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.LayoutResultOfOperationBinding
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.network.model.DetailMealsNetwork
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.BaseFragment
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainSharedViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.RecipeOfMealViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecipeOfMealFragment : BaseFragment() {
    private val sharedVM : MainSharedViewModel by activityViewModels()
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

        val resultBinding = LayoutResultOfOperationBinding.bind(binding?.root!!)

        vm.meal.observe(viewLifecycleOwner){  result ->
            renderResult(
                root = binding?.root!!,
                result = result,
                onSuccess = { meal ->
                    setMeal(meal)
                },
                onError = {
                    resultBinding.buttonErrorRestart.visibility = View.VISIBLE
                    resultBinding.textError.visibility = View.VISIBLE
                }
            )
        }

        vm.loading.observe(viewLifecycleOwner){ isLoaded ->
            if (isLoaded)
            {
                _binding?.scrollView?.visibility = View.VISIBLE
                _binding?.progressBar?.visibility = View.GONE
            }
        }

        _binding?.addFavoritesButton?.setOnClickListener {
            vm.insertRecipeToFavorite()
            Toast.makeText(requireContext(), "Recipe is inserted to favorites", Toast.LENGTH_LONG)
                .show()
            findNavController().popBackStack()
        }

        _binding?.goBackButton?.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    private fun setMeal(meal: DetailMealNetwork){
        binding?.mealImage?.let {
            Glide.with(requireContext())
                .load(meal.strMealThumb)
                .skipMemoryCache(true)
                .centerCrop()
                .into(it)
        }
        binding?.mealName?.visibility = View.VISIBLE
        binding?.goBackButton?.visibility = View.VISIBLE
        binding?.mealImage?.visibility = View.VISIBLE
        binding?.addFavoritesButton?.visibility = View.VISIBLE
        binding?.scrollView?.visibility = View.VISIBLE
        binding?.mealIngredientsAndMeasure?.visibility = View.VISIBLE
        binding?.textIngredient?.visibility = View.VISIBLE
        binding?.textInstructions?.visibility = View.VISIBLE
        binding?.textInstructions?.text = meal.strInstructions
        binding?.mealName?.text = meal.strMeal
        binding?.mealIngredientsAndMeasure?.text = vm.textIngredientsAndMeasure
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
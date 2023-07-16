package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentFavoriteRecipeBinding
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentFavoritesMealsBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.FavoriteRecipeViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.FavoritesSharedViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteRecipeFragment : Fragment() {

    private var _binding : FragmentFavoriteRecipeBinding? = null
    private val binding
        get() = _binding

    val vm : FavoriteRecipeViewModel by viewModels()
    val sharedVM : FavoritesSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteRecipeBinding.inflate(layoutInflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.delay()

        sharedVM.get().observe(viewLifecycleOwner) { recipe ->
            Glide.with(requireContext())
                .load(recipe.strMealThumb)
                .skipMemoryCache(true)
                .centerCrop()
                .into(binding?.mealImage!!)

            binding?.mealIngredientsAndMeasure?.text = vm.setTextOfEngridients(recipe)
            binding?.textInstructions?.text = recipe.strInstructions
            binding?.mealName?.text = recipe.strMeal
            _binding?.deleteFavoritesButton?.setOnClickListener {
                vm.deleteRecipeFromFavorites(recipe)
                Toast.makeText(requireContext(),
                    "Recipe is deleted from favorites", Toast.LENGTH_LONG)
                    .show()
                val action = FavoriteRecipeFragmentDirections.actionFavoriteRecipeFragmentToCategorieslListFragment()
                findNavController().navigate(action)
            }
        }

        vm.loading.observe(viewLifecycleOwner){ loading ->
            if (loading){
                _binding?.scrollView?.visibility = View.VISIBLE
                _binding?.progressBar?.visibility = View.GONE
            }
        }

        _binding?.goBackButton?.setOnClickListener {
            val action = FavoriteRecipeFragmentDirections.actionFavoriteRecipeFragmentToCategorieslListFragment()
            findNavController().navigate(action)
        }
    }
}

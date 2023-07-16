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
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentFavoriteRecipeBinding
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentFavoritesMealsBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.FavoriteRecipeViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.FavoritesSharedViewModel
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
        _binding?.deleteFavoritesButton?.setOnClickListener {
            sharedVM.get().observe(viewLifecycleOwner){ recipe ->
                if (recipe != null)
                {
                    vm.deleteRecipeFromFavorites(recipe)
                    Toast.makeText(requireContext(), "Recipe is delete from favorites", Toast.LENGTH_LONG)
                        .show()
                    findNavController().popBackStack()
                }
            }
        }


    }
}
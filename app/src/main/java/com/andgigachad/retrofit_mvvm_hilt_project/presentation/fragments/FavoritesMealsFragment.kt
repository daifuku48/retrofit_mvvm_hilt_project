package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentFavoritesMealsBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.RecyclerFavoriteMealsAdapter
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.FavoritesMealsViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.FavoritesSharedViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoritesMealsFragment : Fragment() {
    private var _binding : FragmentFavoritesMealsBinding? = null
    private val binding
        get() = _binding

    private val vm : FavoritesMealsViewModel by viewModels()
    private val sharedVM : FavoritesSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesMealsBinding.inflate(layoutInflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding?.favoritesRecyclerView?.layoutManager = layoutManager

        vm.loading.observe(viewLifecycleOwner){ loading ->
            if (loading)
            {
                binding?.favoritesRecyclerView?.visibility = View.VISIBLE
                binding?.progressBar?.visibility = View.GONE
            }
        }

        vm.recipeList.observe(viewLifecycleOwner){ recipeList ->
            if (recipeList.isEmpty()) {
                //hide recycler is recipeList is Empty
                binding?.goBackButton?.visibility = View.VISIBLE
                binding?.listIsEmptyTextview?.visibility = View.VISIBLE
                binding?.favoritesRecyclerView?.visibility = View.GONE
            } else{
                val adapter = RecyclerFavoriteMealsAdapter(recipeList)
                binding?.favoritesRecyclerView?.adapter = adapter
                adapter.onItemClick = { recipe ->
                    val action = FavoritesMealsFragmentDirections
                        .actionFavoritesMealsFragmentToFavoriteRecipeFragment()
                    sharedVM.set(recipe)
                    findNavController().navigate(action)
                }
            }
        }

        binding?.goBackButton?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
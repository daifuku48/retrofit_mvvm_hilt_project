package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentMealByCategoriesBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.RecyclerMealsAdapter
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MealByCategoriesListViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.SharedViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MealsByCategoriesFragment : Fragment() {

    private var _binding : FragmentMealByCategoriesBinding? = null
    private val binding
        get() = _binding

    private val vm : MealByCategoriesListViewModel by viewModels()
    private val sharedVM : SharedViewModel by viewModels()
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
        val layoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        binding?.mealsRecyclerView?.layoutManager = layoutManager

        sharedVM.getCategoryName().observe(viewLifecycleOwner){ categoryName ->
            if (categoryName != null)
            {
                vm.fetchData(categoryName)
                binding?.categoryName?.text = categoryName
            }
        }

        sharedVM.getCategoryImage().observe(viewLifecycleOwner){ categoryImage ->
            if (categoryImage != null)
            {
                binding?.categoryImage?.let {
                    Glide.with(requireContext())
                        .load(categoryImage)
                        .skipMemoryCache(true)
                        .into(it)
                }
            }
        }

        vm.loading.observe(viewLifecycleOwner){
            if (it)
            {
                binding?.categoryLayout?.visibility = View.VISIBLE
                binding?.mealsRecyclerView?.visibility = View.VISIBLE
                binding?.progressBar?.visibility = View.GONE
            }
        }

        vm.mealsList.observe(viewLifecycleOwner){ items ->
            val adapter = RecyclerMealsAdapter(items)
            binding?.mealsRecyclerView?.adapter = adapter
        }

    }
}
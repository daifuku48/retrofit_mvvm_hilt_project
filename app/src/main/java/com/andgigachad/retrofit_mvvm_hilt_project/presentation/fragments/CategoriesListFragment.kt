package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentCategoriesListBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.RecyclerCategoriesAdapter
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.CategoriesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CategoriesListFragment : Fragment() {
    //init navController
    private val navController by lazy { findNavController() }

    private var _binding : FragmentCategoriesListBinding? = null

    private val vm : CategoriesListViewModel by viewModels()
    //private val vm: CategoriesListViewModel by navGraphViewModels(R.navigation.nav_graph)
    private val binding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesListBinding.inflate(layoutInflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding?.categoriesRecyclerView?.layoutManager = layoutManager

        //making loading
        vm.loading.observe(viewLifecycleOwner) {
            if (it)
            {
                binding?.progressBar?.visibility = View.GONE
                binding?.categoriesRecyclerView?.visibility = View.VISIBLE
            }
        }

        //init recyclerView
        vm.categoriesList.observe(viewLifecycleOwner){ items->
            val adapter = RecyclerCategoriesAdapter(items)
            adapter.onItemClick = { category ->
                val action = CategoriesListFragmentDirections
                    .actionCategorieslListFragmentToMealsByCategoriesFragment(
                        categoryName = category.strCategory
                    )
                navController.navigate(action)
            }
            binding?.categoriesRecyclerView?.adapter = adapter
        }
    }
}
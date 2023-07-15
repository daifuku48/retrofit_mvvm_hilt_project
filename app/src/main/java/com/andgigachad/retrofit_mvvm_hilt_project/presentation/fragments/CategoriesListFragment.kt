package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentCategoriesListBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.RecyclerCategoriesAdapter
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.CategoriesListViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoriesListFragment : Fragment() {
    //init navController
    private val navController by lazy { findNavController() }

    private var _binding : FragmentCategoriesListBinding? = null
    private val binding
        get() = _binding

    private val vm : CategoriesListViewModel by viewModels()
    private val sharedVM : MainSharedViewModel by activityViewModels()
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
                Log.d("Category", category.strCategory)
                val action = CategoriesListFragmentDirections
                    .actionCategorieslListFragmentToMealsByCategoriesFragment()
                sharedVM.setCategoryName(category.strCategory)
                sharedVM.setCategoryImage(category.strCategoryThumb)
                navController.navigate(action)
            }
            binding?.categoriesRecyclerView?.adapter = adapter
        }
        val menuProvider = object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.favorites -> {
                        val action = CategoriesListFragmentDirections
                            .actionCategorieslListFragmentToFavoritesMealsFragment()
                        navController.navigate(action)
                        true
                    }
                    else -> false
                }
            }
        }

        binding?.toolbar?.addMenuProvider(menuProvider)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
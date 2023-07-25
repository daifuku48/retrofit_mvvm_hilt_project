package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentMealByCategoriesBinding
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.LayoutResultOfOperationBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.adapters.RecyclerMealsAdapter
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.BaseFragment
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainSharedViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MealByCategoriesListViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsByCategoriesFragment : BaseFragment() {
    private val navController by lazy { findNavController() }
    private var _binding : FragmentMealByCategoriesBinding? = null
    private val binding
        get() = _binding

    private val vm : MealByCategoriesListViewModel by viewModels()
    private val sharedVM : MainSharedViewModel by activityViewModels()
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
                binding?.categoryLayout?.title = categoryName
            }
        }

        sharedVM.getCategoryImage().observe(viewLifecycleOwner){ categoryImage ->
            if (categoryImage != null)
            {
                Log.d("Category Image", categoryImage)
                Glide.with(requireContext())
                    .load(categoryImage)
                    .skipMemoryCache(true)
                    .into(binding?.categoryImage!!)
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

        val resultBinding = LayoutResultOfOperationBinding.bind(binding?.root!!)

        vm.mealsList.observe(viewLifecycleOwner){ result ->
            renderResult(
                root = binding?.root!!,
                result = result,
                onSuccess = { items ->
                    val adapter = RecyclerMealsAdapter(items)
                    binding?.mealsRecyclerView?.adapter = adapter
                    adapter.onItemClick = { mealNetwork ->
                        val action = MealsByCategoriesFragmentDirections.actionMealsByCategoriesFragmentToRecipeOfMealFragment()
                        sharedVM.setMealName(mealNetwork.strMeal)
                        navController.navigate(action)
                    }
                    binding?.mealsRecyclerView?.visibility = View.VISIBLE
                    binding?.appBarLayout?.visibility = View.VISIBLE
                    binding?.scrollView?.visibility = View.VISIBLE
                },
                onError = {
                    binding?.errorLayout?.visibility = View.VISIBLE
                    resultBinding.buttonErrorRestart.visibility = View.VISIBLE
                    resultBinding.textError.visibility = View.VISIBLE
                    resultBinding.buttonErrorRestart.setOnClickListener {
                        sharedVM.getCategoryImage().value?.let {
                                category -> vm.fetchData(category = category)
                        }
                    }
                }
            )
        }


        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding?.toolbar?.setNavigationOnClickListener {
            navController.navigateUp()
        }
        val menuProvider = object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.favorites -> {
                        val action = MealsByCategoriesFragmentDirections
                            .actionMealsByCategoriesFragmentToFavoritesMealsFragment()
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
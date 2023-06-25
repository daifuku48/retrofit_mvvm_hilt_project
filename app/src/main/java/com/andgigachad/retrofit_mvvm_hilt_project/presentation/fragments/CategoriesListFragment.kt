package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentCategoriesListBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.RecyclerCategoriesAdapter
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.CategoriesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CategoriesListFragment : Fragment() {

    private var _binding : FragmentCategoriesListBinding? = null

    private val vm : CategoriesListViewModel by viewModels()
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

        vm.loading.observe(viewLifecycleOwner) {
            if (it)
            {
                binding?.progressBar?.visibility = View.GONE
                binding?.categoriesRecyclerView?.visibility = View.VISIBLE
            }
        }


        vm.categoriesList.observe(viewLifecycleOwner){ items->
            val adapter = RecyclerCategoriesAdapter(items)
            adapter.onItemClick = {
                Toast.makeText(requireContext(), it.strCategory, Toast.LENGTH_LONG).show()
            }
            for(i in items)
            {
                Log.d("items", i.strCategory)
            }
            binding?.categoriesRecyclerView?.adapter = adapter
        }



    }
}
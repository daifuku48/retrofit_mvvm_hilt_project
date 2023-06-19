package com.andgigachad.retrofit_mvvm_hilt_project.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentCategoriesListBinding
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoriesListFragment : Fragment() {

    private val vm: MainViewModel by viewModels()
    private var _binding : FragmentCategoriesListBinding? = null

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

    }
}
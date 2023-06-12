package com.andgigachad.retrofit_mvvm_hilt_project.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.FragmentAllFruitsBinding

class FruitListFragment : Fragment() {

    private var _binding : FragmentAllFruitsBinding? = null
    private val binding
        get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllFruitsBinding.inflate(layoutInflater)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
package com.andgigachad.retrofit_mvvm_hilt_project.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.data.repository.FavoriteMealRepositoryImpl
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.ActivityMainBinding
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding
    private val vm: MainViewModel by viewModels<MainViewModel>(){
        MainViewModelFactory(this, FavoriteMealRepositoryImpl(), intent.extras,)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_main) as NavHostFragment

    }
}
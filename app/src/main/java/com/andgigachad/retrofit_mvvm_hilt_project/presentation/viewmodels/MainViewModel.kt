package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class MainViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: FavoriteMealRepository
) : ViewModel() {

}
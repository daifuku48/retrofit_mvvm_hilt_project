package com.andgigachad.retrofit_mvvm_hilt_project.presentation.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.andgigachad.retrofit_mvvm_hilt_project.app.App
import com.andgigachad.retrofit_mvvm_hilt_project.domain.repository.FavoriteMealRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: FavoriteMealRepository,
    private val savedStateHandle: SavedStateHandle,
    private val coroutineScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
) : ViewModel() {




    override fun onCleared() {
        coroutineScope.cancel()
    }
}
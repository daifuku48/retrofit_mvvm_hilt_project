package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.ErrorResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.Event
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.SuccessResult
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.Result


typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>


abstract class BaseFragment : Fragment() {
    /**
     * Hide all views in the [root] and then call one of the provided lambda functions
     * depending on [result]:
     * - [onPending] is called when [result] is [PendingResult]
     * - [onSuccess] is called when [result] is [SuccessResult]
     * - [onError] is called when [result] is [ErrorResult]
     */
    fun <T> renderResult(root: ViewGroup, result: Result<T>,
                         onError: (Exception) -> Unit,
                         onSuccess: (T) -> Unit) {

        root.children.forEach { it.visibility = View.GONE }
        when (result) {
            is SuccessResult<*> -> {
                onSuccess(result.data as T)
            }
            is ErrorResult<*> -> {
                onError(result.exception as Exception)
            }
        }

    }
}
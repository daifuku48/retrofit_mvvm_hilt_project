package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.Event
import com.andgigachad.retrofit_mvvm_hilt_project.domain.model.Result

/**
 * Base class for all view-models.
 */

typealias LiveEvent<T> = LiveData<Event<T>>
typealias MutableLiveEvent<T> = MutableLiveData<Event<T>>

typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>
typealias MediatorLiveResult<T> = MediatorLiveData<Result<T>>

open class BaseViewModel : ViewModel() {

    /**
     * Override this method in child classes if you want to listen for results
     * from other screens
     */
    open fun onResult(result: Any) {

    }

}
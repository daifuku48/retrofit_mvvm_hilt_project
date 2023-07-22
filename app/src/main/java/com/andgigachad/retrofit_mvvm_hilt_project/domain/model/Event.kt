package com.andgigachad.retrofit_mvvm_hilt_project.domain.model

import androidx.lifecycle.LiveData

/**
 * Represents "side effect".
 * Used in [LiveData] as a wrapper for events.
 */
class Event<T>(
    private val value: T
) {
    private var handled: Boolean = false

    fun getValue(): T? {
        if (handled) return null
        handled = true
        return value
    }

}
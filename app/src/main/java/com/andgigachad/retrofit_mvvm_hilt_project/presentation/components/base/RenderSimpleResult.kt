package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import com.andgigachad.retrofit_mvvm_hilt_project.R
import com.andgigachad.retrofit_mvvm_hilt_project.databinding.LayoutResultOfOperationBinding


fun <T> BaseFragment.renderSimpleResult(root: ViewGroup, result: Result<T>, onSuccess: (T) -> Unit) {
    val binding = LayoutResultOfOperationBinding.bind(root)

    renderResult(
        root = root,
        result = result,
        onError = {
            binding.buttonErrorRestart.visibility = View.VISIBLE
            binding.textError.visibility = View.VISIBLE
        },
        onSuccess = { successData ->
            root.children
                .filter { it.id != R.id.button_error_restart && it.id != R.id.text_error }
                .forEach { it.visibility = View.VISIBLE }
            onSuccess(successData)
        }
    )
}

/**
 * Assign onClick listener for default try-again button.
 */
fun BaseFragment.onTryAgain(root: View, onTryAgainPressed: () -> Unit) {
    root.findViewById<Button>(R.id.button_error_restart).setOnClickListener { onTryAgainPressed() }
}

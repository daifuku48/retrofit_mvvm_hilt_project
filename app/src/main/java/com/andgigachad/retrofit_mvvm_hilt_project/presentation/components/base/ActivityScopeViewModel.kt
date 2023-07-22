package com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base

import androidx.lifecycle.ViewModel
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.navigator.Navigator
import com.andgigachad.retrofit_mvvm_hilt_project.presentation.navigator.UiActions


class ActivityScopeViewModel(
    val uiActions: UiActions,
    val navigator: IntermediateNavigator
) : ViewModel(),
    Navigator by navigator,
    UiActions by uiActions {

    override fun onCleared() {
        super.onCleared()
        navigator.clear()
    }

}
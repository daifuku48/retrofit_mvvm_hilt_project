package com.andgigachad.retrofit_mvvm_hilt_project.presentation.navigator

import com.andgigachad.retrofit_mvvm_hilt_project.presentation.components.base.BaseScreen

interface Navigator {

    /**
     * Launch a new screen at the top of back stack.
     */
    fun launch(screen: BaseScreen)

    /**
     * Go back to the previous screen and optionally send some results.
     */
    fun goBack(result: Any? = null)

}
package com.andgigachad.retrofit_mvvm_hilt_project.domain.use_cases

import androidx.lifecycle.LiveData
import com.andgigachad.retrofit_mvvm_hilt_project.data.internet.NetworkChecker
import javax.inject.Inject

class CheckInternetConnectionUseCase @Inject constructor(
    private val networkChecker: NetworkChecker
) {
    suspend fun execute() : Boolean {
        return networkChecker.isNetworkAvailable()
    }
}
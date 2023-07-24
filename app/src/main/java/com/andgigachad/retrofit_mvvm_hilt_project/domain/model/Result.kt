package com.andgigachad.retrofit_mvvm_hilt_project.domain.model

import java.lang.Exception


typealias Mapper<Input, Output> = (Input) -> Output

sealed class Result<T>{
    fun <R> map(mapper: Mapper<T, R>) : Result<R> = when(this) {
        is ErrorResult -> ErrorResult(this.exception)
        is SuccessResult -> {
            SuccessResult(mapper(this.data))
        }
    }
}


data class SuccessResult<T>(
    val data: T
) : Result<T>()

data class ErrorResult<T>(
    val exception: Exception
) : Result<T>()

package com.andgigachad.retrofit_mvvm_hilt_project.domain.model


typealias Mapper<Input, Output> = (Input) -> Output

sealed class Result<T>{
    fun <R> map(mapper: Mapper<T, R>) : Result<R> = when(this) {
        is PendingResult -> PendingResult()
        is ErrorResult -> ErrorResult(mapper(this.exception))
        is SuccessResult -> {
            SuccessResult(mapper(this.data))
        }
    }
}


class PendingResult<T> : Result<T>()

class SuccessResult<T>(
    val data: T
) : Result<T>()

class ErrorResult<T>(
    val exception: T
) : Result<T>()

fun <T> Result<T>?.takeAccess() : T? {
    return if (this is SuccessResult)
        this.data
    else
        null
}



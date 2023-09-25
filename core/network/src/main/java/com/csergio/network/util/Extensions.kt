package com.csergio.network.util

import retrofit2.Response

fun <T> Response<T>.asResult(): Result<T> {
    val body = body()
    return if (isSuccessful && body != null) {
        Result.success(body)
    } else {
        val errorMessage = errorBody()?.string() ?: message()
        Result.failure(Throwable(errorMessage))
    }
}
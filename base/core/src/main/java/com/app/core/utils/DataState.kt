package com.app.core.utils


sealed class DataState<out T : Any> {
    object Loading : DataState<Nothing>()
    data class Success<out T : Any>(val result: T) : DataState<T>()
    data class Error(val exception: NetworkError) : DataState<Nothing>()
}

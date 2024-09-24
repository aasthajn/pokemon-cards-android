package com.app.core.utils


interface Mapper<F, T> {
    suspend fun map(from: F): T
}

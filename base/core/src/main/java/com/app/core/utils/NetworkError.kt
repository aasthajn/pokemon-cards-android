package com.app.core.utils

import org.json.JSONObject
import retrofit2.HttpException


open class NetworkError(
    val errorCode: Int = -1,
    val errorMessage: String,
    val response: String = ""
) : Exception() {
    override val message: String
        get() = localizedMessage

    override fun getLocalizedMessage(): String {
        return errorMessage
    }

    companion object {
        fun parseException(e: HttpException): NetworkError {
            val errorBody = e.response()?.errorBody()?.string()

            return try {//here you can parse the error body that comes from server
                NetworkError(e.code(), JSONObject(errorBody!!).getString("error"))
            } catch (_: Exception) {
                NetworkError(e.code(), "unexpected error!!ً")
            }
        }
    }
}

class AuthenticationException(authMessage: String) :
    NetworkError(errorMessage = authMessage)

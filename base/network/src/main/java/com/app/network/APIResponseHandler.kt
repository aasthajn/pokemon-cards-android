package com.app.network

import com.app.core.utils.DataState
import com.app.core.utils.NetworkError
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

object APIResponseHandler {

    fun resolveError(e: Exception): DataState.Error {
        var error = NetworkError(errorMessage = "something went wrong")

        when (e) {
            is SocketTimeoutException -> {
                error = NetworkError(errorMessage = "connection timeout!")
            }

            is ConnectException -> {
                error = NetworkError(errorMessage = "no internet access!")
            }

            is UnknownHostException -> {
                error = NetworkError(errorMessage = "no internet access!")
            }

            is SSLHandshakeException -> {
                error = NetworkError(errorMessage = "Invalid request!")
            }

            is HttpException -> {
                when (e.code()) {
                    502 -> {
                        error = NetworkError(e.code(), "internal error!")
                    }

                    401 -> {
                        error = NetworkError(e.code(), "authentication error!")
                    }

                    400 -> {
                        error = NetworkError.parseException(e)
                    }
                }
            }
        }


        return DataState.Error(error)
    }
}

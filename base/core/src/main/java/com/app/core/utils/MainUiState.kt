package com.app.core.utils

sealed class MainUiState {
    object Init : MainUiState()
    object Loading : MainUiState()
    data class Success<T>(val cards: List<T>) : MainUiState()
    data class Error(val message: String) : MainUiState()
}

package com.app.detail.presentation

import com.app.domain.model.CardData

sealed interface CardDetailUiState {

    object Init : CardDetailUiState

    data class Success(
        val cardData: CardData
    ) : CardDetailUiState

    object Loading : CardDetailUiState
    data class Error(val message: String) : CardDetailUiState
}

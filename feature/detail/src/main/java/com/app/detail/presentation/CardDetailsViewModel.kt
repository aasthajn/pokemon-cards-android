package com.app.detail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.core.utils.DataState
import com.app.detail.cardIdArg
import com.app.domain.usecase.GetCardDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val cardDetailUseCase: GetCardDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val cardId = savedStateHandle[cardIdArg] ?: "dp3-1"

    private val _mutableCardDetails = MutableStateFlow<CardDetailUiState>(CardDetailUiState.Init)

    val cardDetails get() = _mutableCardDetails

    init {
        getCardDetails()
    }

    private fun getCardDetails() {
        viewModelScope.launch {
            cardDetailUseCase(cardId).collect {
                when (it) {
                    is DataState.Success -> {
                        _mutableCardDetails.value = CardDetailUiState.Success(it.result)
                    }

                    is DataState.Error -> {
                        _mutableCardDetails.value =
                            CardDetailUiState.Error(it.exception.errorMessage)
                    }

                    is DataState.Loading -> {
                        _mutableCardDetails.value = CardDetailUiState.Loading
                    }
                }
            }
        }

    }
}


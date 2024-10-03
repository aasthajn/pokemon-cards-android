package com.app.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.core.utils.DataState
import com.app.domain.usecase.GetCardListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(private val cardListUseCase: GetCardListUseCase) :
    ViewModel() {
    private val _mutableCardsState = MutableStateFlow<CardListUiState>(CardListUiState.Init)

    val cardsUI get() = _mutableCardsState

    init {
        getCardData()
    }

    fun getCardData() {
        _mutableCardsState.value = CardListUiState.Loading
        viewModelScope.launch {
            _mutableCardsState.value = CardListUiState.Loading
            cardListUseCase().collect {
                when (it) {
                    is DataState.Success -> {
                        _mutableCardsState.value = CardListUiState.Success(it.result)
                    }

                    is DataState.Error -> {
                        _mutableCardsState.value = CardListUiState.Error(it.exception.message)
                    }

                    is DataState.Loading -> {
                        _mutableCardsState.value = CardListUiState.Loading
                    }
                }

            }
        }

    }

}

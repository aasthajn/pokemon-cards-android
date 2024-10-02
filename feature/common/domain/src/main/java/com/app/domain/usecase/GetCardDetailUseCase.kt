package com.app.domain.usecase

import com.app.core.utils.DataState
import com.app.domain.model.CardData
import com.app.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardDetailUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(cardId: String): Flow<DataState<CardData>> =
        repository.getCardDetails(cardId)
}

package com.app.domain.repository

import com.app.core.utils.DataState
import com.app.domain.model.CardData
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun getTrendingCards(): Flow<DataState<List<CardData>>>

    suspend fun getCardDetails(id: String): Flow<DataState<CardData>>
}

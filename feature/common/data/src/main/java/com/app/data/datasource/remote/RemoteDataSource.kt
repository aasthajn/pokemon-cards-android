package com.app.data.datasource.remote

import com.app.data.datasource.remote.model.detail.CardDetails
import com.app.data.datasource.remote.model.list.CardsResponse

interface RemoteDataSource {
    suspend fun getTrendingCards(): CardsResponse

    suspend fun getCardDetails(cardId: String): CardDetails
}

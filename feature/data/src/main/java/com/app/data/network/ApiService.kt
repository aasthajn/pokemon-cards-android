package com.app.data.network

import com.app.data.datasource.remote.model.detail.CardDetails
import com.app.data.datasource.remote.model.list.CardsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v2/cards")
    suspend fun getTrendingCards(
    ): CardsResponse

    @GET("/v2/cards/{cardId}")
    suspend fun getCardDetails(@Path("cardId") cardId: String): CardDetails
}

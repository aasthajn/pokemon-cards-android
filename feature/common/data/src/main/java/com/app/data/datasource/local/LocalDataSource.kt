package com.app.data.datasource.local

import com.app.database.entity.CardsDBEntity

interface LocalDataSource {

    suspend fun getTrendingCards(): List<CardsDBEntity>?
    suspend fun insertCards(list: List<CardsDBEntity>)
    suspend fun delete()
    suspend fun getCardDetails(cardId: String): CardsDBEntity?
    suspend fun insertCard(cardsDBEntity: CardsDBEntity)
}

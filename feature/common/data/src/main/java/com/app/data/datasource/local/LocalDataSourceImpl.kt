package com.app.data.datasource.local

import com.app.database.dao.CardsDao
import com.app.database.entity.CardsDBEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: CardsDao) : LocalDataSource {
    override suspend fun getTrendingCards(): List<CardsDBEntity>? {
        return dao.getCards()
    }

    override suspend fun insertCards(list: List<CardsDBEntity>) {
        dao.upsertAll(list)
    }

    override suspend fun delete() {
        dao.clearAll()
    }

    override suspend fun getCardDetails(cardId: String): CardsDBEntity? {
        return dao.getCard(cardId)
    }

    override suspend fun insertCard(cardsDBEntity: CardsDBEntity) {
        dao.insertCard(cardsDBEntity)
    }
}

package com.app.data.datasource.mapper

import com.app.core.utils.Mapper
import com.app.database.entity.CardsDBEntity
import com.app.domain.model.CardData
import javax.inject.Inject

class LocalToDomainMapper @Inject constructor() : Mapper<CardsDBEntity, CardData> {

    override suspend fun map(from: CardsDBEntity): CardData {
        return CardData(
            id = from.cardId,
            thumbnail = from.thumbnail,
            image = from.image

        )
    }
}

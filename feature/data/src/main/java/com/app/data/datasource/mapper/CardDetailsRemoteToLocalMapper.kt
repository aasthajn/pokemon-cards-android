package com.app.data.datasource.mapper

import com.app.core.utils.Mapper
import com.app.data.datasource.remote.model.detail.Data
import com.app.database.entity.CardsDBEntity
import javax.inject.Inject

class CardDetailsRemoteToLocalMapper @Inject constructor() :
    Mapper<Data, CardsDBEntity> {
    override suspend fun map(from: Data): CardsDBEntity {
        return CardsDBEntity(
            cardId = from.id,
            thumbnail = from.images.small,
            image = from.images.large
        )

    }
}

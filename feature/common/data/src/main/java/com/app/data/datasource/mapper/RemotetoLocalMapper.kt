package com.app.data.datasource.mapper

import com.app.core.utils.Mapper
import com.app.data.datasource.remote.model.list.CardsNetworkEntity
import com.app.database.entity.CardsDBEntity
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor() :
    Mapper<CardsNetworkEntity, CardsDBEntity> {
    override suspend fun map(from: CardsNetworkEntity): CardsDBEntity {
        return CardsDBEntity(
            cardId = from.id,
            thumbnail = from.images.small,
            image = from.images.large
        )
    }
}

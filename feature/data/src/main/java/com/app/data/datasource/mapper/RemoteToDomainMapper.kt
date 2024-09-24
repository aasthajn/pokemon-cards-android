package com.app.data.datasource.mapper

import com.app.core.utils.Mapper
import com.app.data.datasource.remote.model.list.CardsNetworkEntity
import com.app.domain.model.CardData
import javax.inject.Inject

class RemoteToDomainMapper @Inject constructor() :
    Mapper<CardsNetworkEntity, CardData> {
    override suspend fun map(from: CardsNetworkEntity): CardData {
        return CardData(
            id = from.id,
            thumbnail = from.images.small,
            image = from.images.large
        )
    }
}

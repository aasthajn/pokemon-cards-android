package com.app.data.datasource.mapper

import com.app.core.utils.Mapper
import com.app.data.datasource.remote.model.detail.Data
import com.app.domain.model.CardData
import javax.inject.Inject

class CardDetailsRemoteToDomainMapper @Inject constructor() :
    Mapper<Data, CardData> {
    override suspend fun map(from: Data): CardData {
        return CardData(
            id = from.id,
            thumbnail = from.images.small,
            image = from.images.large
        )
    }
}

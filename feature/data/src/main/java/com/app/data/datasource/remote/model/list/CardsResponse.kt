package com.app.data.datasource.remote.model.list

import com.google.gson.annotations.SerializedName

data class CardsResponse(

    @SerializedName("data")
    val cards: List<CardsNetworkEntity>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)

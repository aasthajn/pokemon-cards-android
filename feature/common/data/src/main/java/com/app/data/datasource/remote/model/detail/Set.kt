package com.app.data.datasource.remote.model.detail

data class Set(
    val id: String,
    val images: ImagesX,
    val legalities: Legalities,
    val name: String,
    val printedTotal: Int,
    val ptcgoCode: String,
    val releaseDate: String,
    val series: String,
    val total: Int,
    val updatedAt: String
)

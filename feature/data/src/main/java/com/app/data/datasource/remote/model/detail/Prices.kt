package com.app.data.datasource.remote.model.detail

data class Prices(
    val averageSellPrice: Double,
    val avg1: Int,
    val avg30: Double,
    val avg7: Double,
    val germanProLow: Int,
    val lowPrice: Int,
    val lowPriceExPlus: Double,
    val reverseHoloAvg1: Double,
    val reverseHoloAvg30: Double,
    val reverseHoloAvg7: Double,
    val reverseHoloLow: Int,
    val reverseHoloSell: Int,
    val reverseHoloTrend: Double,
    val suggestedPrice: Int,
    val trendPrice: Double
)

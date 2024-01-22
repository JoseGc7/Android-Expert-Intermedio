package com.josegc7.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.josegc7.horoscapp.domain.model.PredictionModel

data class PredictionsResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel? {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}
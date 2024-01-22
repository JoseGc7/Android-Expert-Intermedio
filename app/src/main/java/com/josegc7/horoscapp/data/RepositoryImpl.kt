package com.josegc7.horoscapp.data

import android.util.Log
import com.josegc7.horoscapp.data.network.HoroscopeApiService
import com.josegc7.horoscapp.domain.Repository
import com.josegc7.horoscapp.domain.model.PredictionModel
import javax.inject.Inject


class RepositoryImpl @Inject constructor(private val apiservice: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiservice.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("JoseGcDev7", "Ha ocurrido un error ${it.message}") }
        return null
    }
}
package com.josegc7.horoscapp.data.provider

import com.josegc7.horoscapp.domain.model.HoroscopeInfo
import com.josegc7.horoscapp.domain.model.HoroscopeInfo.*

class HoroscopeProvider {
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}
package com.baharudin.wheaterapp.domain.repository

import com.baharudin.wheaterapp.domain.util.Resource
import com.baharudin.wheaterapp.domain.wheather.WheatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(latitude : Double, longitude : Double) : Resource<WheatherInfo>
}
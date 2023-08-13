package com.baharudin.wheaterapp.presentation.weather

import com.baharudin.wheaterapp.domain.wheather.WheatherInfo

data class WeatherState(
    val weatherInfo : WheatherInfo? = null,
    val isLoading : Boolean = false,
    val error : String? = null
)
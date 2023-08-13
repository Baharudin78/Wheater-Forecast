package com.baharudin.wheaterapp.domain.wheather

import java.time.LocalDateTime

data class WheatherData(
    val time : LocalDateTime,
    val tempetaturesCelcius : Double,
    val pressure : Double,
    val windSpeed : Double,
    val humidity : Double,
    val wheatherType : WheatherType
)

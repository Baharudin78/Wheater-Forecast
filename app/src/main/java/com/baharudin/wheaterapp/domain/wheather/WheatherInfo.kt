package com.baharudin.wheaterapp.domain.wheather

data class WheatherInfo(
    val wheatherPerDay : Map<Int, List<WheatherData>>,
    val currentWheatherData : WheatherData?
)

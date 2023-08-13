package com.baharudin.wheaterapp.data.remote

import com.squareup.moshi.Json

data class WheatherDto(
    @field:Json(name = "hourly")
    val wheatherData : WheatherDataDto
)

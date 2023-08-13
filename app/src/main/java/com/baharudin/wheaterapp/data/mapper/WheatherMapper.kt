package com.baharudin.wheaterapp.data.mapper

import com.baharudin.wheaterapp.data.remote.WheatherDataDto
import com.baharudin.wheaterapp.data.remote.WheatherDto
import com.baharudin.wheaterapp.domain.wheather.WheatherData
import com.baharudin.wheaterapp.domain.wheather.WheatherInfo
import com.baharudin.wheaterapp.domain.wheather.WheatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class IndexedWeatherData(
    val index : Int,
    val data : WheatherData
)
fun WheatherDataDto.toWheatherDataMap() : Map<Int, List<WheatherData>>{
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val wheatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WheatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                tempetaturesCelcius = temperature,
                windSpeed = windSpeed,
                pressure = pressure,
                humidity = humidity,
                wheatherType = WheatherType.fromWMO(wheatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        it.value.map {
            it.data
        }
    }
}

fun WheatherDto.toWeatherInfo() : WheatherInfo {
    val weatherDataMap = wheatherData.toWheatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = when{
            now.minute < 30 -> now.hour
            now.hour == 23 -> 12.00
            else -> now.hour + 1
        }
        it.time.hour == hour
    }
    return WheatherInfo(
        wheatherPerDay = weatherDataMap,
        currentWheatherData = currentWeatherData
    )
}
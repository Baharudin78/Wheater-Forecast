package com.baharudin.wheaterapp.data.repositoryImpl

import com.baharudin.wheaterapp.data.mapper.toWeatherInfo
import com.baharudin.wheaterapp.data.remote.WheatherApi
import com.baharudin.wheaterapp.domain.repository.WeatherRepository
import com.baharudin.wheaterapp.domain.util.Resource
import com.baharudin.wheaterapp.domain.wheather.WheatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi : WheatherApi
) : WeatherRepository{
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WheatherInfo> {
        return try {
            Resource.Success(
                data = weatherApi.getWeatherData(
                    latitude, longitude
                ).toWeatherInfo()
            )
        }catch (e : Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Un Error Occured.")
        }
    }
}
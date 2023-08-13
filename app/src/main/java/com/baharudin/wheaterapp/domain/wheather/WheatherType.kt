package com.baharudin.wheaterapp.domain.wheather

import androidx.annotation.DrawableRes
import com.baharudin.wheaterapp.R

sealed class WheatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WheatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.ic_sunny
    )
    object MainlyClear : WheatherType(
        weatherDesc = "Mainly clear",
        iconRes = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WheatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.ic_cloudy
    )
    object Overcast : WheatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable.ic_cloudy
    )
    object Foggy : WheatherType(
        weatherDesc = "Foggy",
        iconRes = R.drawable.ic_verycloudy
    )
    object DepositingRimeFog : WheatherType(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.ic_verycloudy
    )
    object LightDrizzle : WheatherType(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WheatherType(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WheatherType(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WheatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.ic_showyrain
    )
    object DenseFreezingDrizzle : WheatherType(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.ic_showyrain
    )
    object SlightRain : WheatherType(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.ic_rainy
    )
    object ModerateRain : WheatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyRain : WheatherType(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WheatherType(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.ic_showyrain
    )
    object SlightSnowFall: WheatherType(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.ic_showy
    )
    object ModerateSnowFall: WheatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.ic_heavysnowy
    )
    object HeavySnowFall: WheatherType(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.ic_heavysnowy
    )
    object SnowGrains: WheatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.ic_heavysnowy
    )
    object SlightRainShowers: WheatherType(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WheatherType(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WheatherType(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WheatherType(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.ic_showy
    )
    object HeavySnowShowers: WheatherType(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.ic_showy
    )
    object ModerateThunderstorm: WheatherType(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WheatherType(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WheatherType(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WheatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}
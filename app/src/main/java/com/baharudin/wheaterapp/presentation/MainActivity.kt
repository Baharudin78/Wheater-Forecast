package com.baharudin.wheaterapp.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Modifier
import com.baharudin.wheaterapp.presentation.ui.theme.DarkBlue
import com.baharudin.wheaterapp.presentation.ui.theme.DeepBlue
import com.baharudin.wheaterapp.presentation.ui.theme.WheaterAppTheme
import com.baharudin.wheaterapp.presentation.weather.WeatherCard
import com.baharudin.wheaterapp.presentation.weather.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel : WeatherViewModel by viewModels()
    private lateinit var permissionLauncher : ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            WheaterAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkBlue)
                ) {
                    WeatherCard(state = viewModel.state, backgroundColor = CardDefaults.cardColors())
                }
            }
        }
    }
}
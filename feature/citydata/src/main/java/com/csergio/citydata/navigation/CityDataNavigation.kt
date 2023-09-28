package com.csergio.citydata.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.csergio.citydata.CityDataScreen
import com.csergio.citydata.viewmodel.CityDataViewModel

const val cityDataRoute = "city_data_route"

fun NavController.navigateToCityData() {
    navigate(cityDataRoute)
}

fun NavGraphBuilder.cityDataScreen() {
    composable(cityDataRoute) {
        val viewModel = hiltViewModel<CityDataViewModel>()
        CityDataScreen(viewModel)
    }
}
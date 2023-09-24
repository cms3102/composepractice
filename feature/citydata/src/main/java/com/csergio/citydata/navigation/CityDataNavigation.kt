package com.csergio.citydata.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.csergio.citydata.CityDataScreen

const val cityDataRoute = "city_data_route"

fun NavController.navigateToCityData() {

}

fun NavGraphBuilder.cityDataScreen() {
    composable(cityDataRoute) {
        CityDataScreen()
    }
}
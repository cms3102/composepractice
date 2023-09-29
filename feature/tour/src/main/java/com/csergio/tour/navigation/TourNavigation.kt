package com.csergio.tour.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.csergio.tour.TourScreen
import com.csergio.tour.viewmodel.TourViewModel

const val tourRoute = "tour_route"

fun NavController.navigateToTour() {
    navigate(tourRoute)
}

fun NavGraphBuilder.tourScreen() {
    composable(tourRoute) {
        val viewModel = hiltViewModel<TourViewModel>()
        TourScreen(viewModel)
    }
}
package com.csergio.tour.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.csergio.domain.entity.TourData
import com.csergio.tour.screen.TourDetailScreen
import com.csergio.tour.screen.TourScreen
import com.csergio.tour.viewmodel.TourViewModel
import com.google.gson.Gson

const val tourRoute = "tour_route"
const val tourDetailRoute = "tour_detail_route"
const val tourDetailArg = "tourData"

fun NavController.navigateToTour() {
    navigate(tourRoute)
}

fun NavGraphBuilder.tourScreen(onItemClick: (TourData) -> Unit) {
    composable(tourRoute) {
        val viewModel = hiltViewModel<TourViewModel>()
        TourScreen(
            viewModel = viewModel,
            onItemClick = onItemClick
        )
    }
}

fun NavController.navigateToTourDetail(data: String) {
    navigate("$tourDetailRoute/$data")
}

fun NavGraphBuilder.tourDetailScreen() {
    composable(
        route = "$tourDetailRoute/{$tourDetailArg}",
        arguments = listOf(
            navArgument(tourDetailArg) { type = NavType.StringType }
        )
    ) { entry ->
        val dataJson = entry.arguments?.getString(tourDetailArg)
        val dataObjet = Gson().fromJson(dataJson, TourData::class.java)
        TourDetailScreen(data = dataObjet)
    }
}
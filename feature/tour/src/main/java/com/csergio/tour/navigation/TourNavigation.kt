package com.csergio.tour.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Place
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.domain.entity.TourData
import com.csergio.features.tour.R
import com.csergio.tour.screen.TourDetailScreen
import com.csergio.tour.screen.TourScreen
import com.csergio.tour.viewmodel.TourViewModel
import com.google.gson.Gson

const val tourRoute = "tour_route"
const val tourDetailRoute = "tour_detail_route"
const val tourDetailArg = "tourData"

object Tour : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.Place
    override val unselectedIcon: ImageVector = Icons.Outlined.Place
    override val menuTitle: Int = R.string.tour_menu_title
    override val appBarTitle: Int = R.string.tour_app_bar_title
    override val route: String = tourRoute
    override val isMain: Boolean = true
}

object TourDetail : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.Place
    override val unselectedIcon: ImageVector = Icons.Outlined.Place
    override val menuTitle: Int = R.string.tour_menu_title
    override val appBarTitle: Int = R.string.tour_app_bar_title
    override val route: String = tourDetailRoute
    override val isMain: Boolean = false
}


fun NavController.navigateToTour() {
    navigate(tourRoute)
}

fun NavGraphBuilder.tourScreen(navController: NavController, onItemClick: (TourData) -> Unit) {
    composable(tourRoute) {
        val viewModel = hiltViewModel<TourViewModel>()
        TourScreen(
            navController = navController,
            viewModel = viewModel,
            onItemClick = onItemClick
        )
    }
}

fun NavController.navigateToTourDetail(data: String) {
    navigate("$tourDetailRoute/$data")
}

fun NavGraphBuilder.tourDetailScreen(navController: NavController) {
    composable(
        route = "$tourDetailRoute/{$tourDetailArg}",
        arguments = listOf(
            navArgument(tourDetailArg) { type = NavType.StringType }
        )
    ) { entry ->
        val dataJson = entry.arguments?.getString(tourDetailArg)
        val dataObjet = Gson().fromJson(dataJson, TourData::class.java)
        TourDetailScreen(
            navController = navController,
            data = dataObjet
        )
    }
}
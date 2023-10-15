package com.csergio.map.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Place
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.map.R
import com.csergio.map.ui.MapScreen

const val mapRoute = "map_route"

object GoogleMap : DestinationProtocol {
    override val selectedIcon: ImageVector
        get() = Icons.Filled.Place
    override val unselectedIcon: ImageVector
        get() = Icons.Outlined.Place
    override val menuTitle: Int
        get() = R.string.map_menu_title
    override val appBarTitle: Int
        get() = R.string.map_app_bar_title
    override val route: String
        get() = mapRoute
    override val isMain: Boolean
        get() = true
}

fun NavController.navigateToMap() {
    navigate(mapRoute)
}

fun NavGraphBuilder.mapScreen() {
    composable(mapRoute) {
        MapScreen()
    }
}
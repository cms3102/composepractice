package com.csergio.composepractice.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.composepractice.R
import com.csergio.settings.navigation.settingsRoute
import com.csergio.tour.navigation.tourDetailRoute
import com.csergio.tour.navigation.tourRoute

internal val mainDestinations = listOf(
    Tour,
    Undefined,
    Settings
)

internal val destinations = listOf(
    Tour,
    TourDetail,
    Undefined,
    Settings
)

object Tour : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.Place
    override val unselectedIcon: ImageVector = Icons.Outlined.Place
    override val menuTitle: Int = R.string.tour_menu_title
    override val appBarTitle: Int = R.string.tour_app_bar_title
    override val route: String = tourRoute
}

object TourDetail : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.Place
    override val unselectedIcon: ImageVector = Icons.Outlined.Place
    override val menuTitle: Int = R.string.tour_menu_title
    override val appBarTitle: Int = R.string.tour_app_bar_title
    override val route: String = tourDetailRoute
}

object Undefined : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.AddCircle
    override val unselectedIcon: ImageVector = Icons.Outlined.AddCircle
    override val menuTitle: Int = R.string.undefined_title
    override val appBarTitle: Int = R.string.undefined_app_bar_title
    override val route: String = "undefined_route"
}

object Settings : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.Settings
    override val unselectedIcon: ImageVector = Icons.Outlined.Settings
    override val menuTitle: Int = R.string.settings_title
    override val appBarTitle: Int = R.string.settings_app_bar_title
    override val route: String = settingsRoute
}

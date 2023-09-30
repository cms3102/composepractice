package com.csergio.composepractice.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.csergio.composepractice.R
import com.csergio.settings.navigation.navigateToSettings
import com.csergio.tour.navigation.navigateToTour

enum class MainDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val menuTitle: Int,
    val appBarTitle: Int,
) {
    Tour(
        selectedIcon = Icons.Filled.Place,
        unselectedIcon = Icons.Outlined.Place,
        menuTitle = R.string.tour_menu_title,
        appBarTitle = R.string.tour_app_bar_title
    ),
    Undefined(
        selectedIcon = Icons.Filled.AddCircle,
        unselectedIcon = Icons.Outlined.AddCircle,
        menuTitle = R.string.undefined_title,
        appBarTitle = R.string.undefined_app_bar_title
    ),
    Settings(
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        menuTitle = R.string.settings_title,
        appBarTitle = R.string.settings_app_bar_title
    )
}

internal fun NavController.navigateToTab(destination: MainDestination) {
    when(destination) {
        MainDestination.Tour -> navigateToTour()
        MainDestination.Undefined -> { }
        MainDestination.Settings -> navigateToSettings()
    }
}
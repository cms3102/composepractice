package com.csergio.settings.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.feature.settings.R
import com.csergio.settings.ui.SettingsScreen

const val settingsRoute = "settings_route"

object Settings : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.Settings
    override val unselectedIcon: ImageVector = Icons.Outlined.Settings
    override val menuTitle: Int = R.string.settings_title
    override val appBarTitle: Int = R.string.settings_app_bar_title
    override val route: String = settingsRoute
    override val isMain: Boolean = true
}

fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    navigate(settingsRoute, navOptions)
}

fun NavGraphBuilder.settingsScreen(navController: NavController) {
    composable(route = settingsRoute) {
        SettingsScreen(navController)
    }
}
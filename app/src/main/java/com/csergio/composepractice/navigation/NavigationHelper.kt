package com.csergio.composepractice.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.introduce.navigation.introduceRoute
import com.csergio.login.navigation.loginRoute
import com.csergio.settings.navigation.Settings
import com.csergio.settings.navigation.navigateToSettings
import com.csergio.tour.navigation.Tour
import com.csergio.tour.navigation.navigateToTour

object NavigationHelper {
    fun showSystemBars(route: String?): Boolean {
        return route != loginRoute && route != introduceRoute
    }

    internal fun NavController.navigateToTab(destination: DestinationProtocol) {
        when (destination) {
            is Tour -> navigateToTour()
            is Undefined -> {}
            is Settings -> navigateToSettings()
        }
    }

    internal fun NavDestination?.findDestination(): DestinationProtocol? {
        return destinations.find { destination ->
            this?.route?.contains(destination.route, true) ?: false
        }
    }

    internal fun isMain(currentDestination: NavDestination?): Boolean {
        return when (currentDestination?.findDestination()) {
            is Tour,
            is Undefined,
            is Settings -> true
            else -> false
        }
    }

}
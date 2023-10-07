package com.csergio.composepractice.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.ui.graphics.vector.ImageVector
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.composepractice.R
import com.csergio.settings.navigation.Settings
import com.csergio.tour.navigation.Tour
import com.csergio.tour.navigation.TourDetail

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

object Undefined : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.AddCircle
    override val unselectedIcon: ImageVector = Icons.Outlined.AddCircle
    override val menuTitle: Int = R.string.undefined_title
    override val appBarTitle: Int = R.string.undefined_app_bar_title
    override val route: String = "undefined_route"
    override val isMain: Boolean = true
}



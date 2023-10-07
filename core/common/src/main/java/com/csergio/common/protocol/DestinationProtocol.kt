package com.csergio.common.protocol

import androidx.compose.ui.graphics.vector.ImageVector

interface DestinationProtocol {
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
    val menuTitle: Int
    val appBarTitle: Int
    val route: String
    val isMain: Boolean
}
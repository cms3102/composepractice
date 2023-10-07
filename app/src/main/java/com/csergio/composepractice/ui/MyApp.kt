package com.csergio.composepractice.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.common.ui.MyScaffold
import com.csergio.composepractice.navigation.MyNavHost
import com.csergio.composepractice.navigation.NavigationHelper
import com.csergio.composepractice.navigation.NavigationHelper.findDestination
import com.csergio.composepractice.navigation.NavigationHelper.navigateToTab
import com.csergio.composepractice.navigation.mainDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(navHostController: NavHostController = rememberNavController()) {
//    println("현재 위치 : ${currentDestination?.label} / $currentDestination")
    MyScaffold(
        navController = navHostController,
        bottomBar = {
            val backStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = backStackEntry?.destination
            val show = currentDestination?.findDestination()?.isMain ?: false
            println("보여줘 말아 : $show / ${currentDestination?.route}")
            if (show) {
                BottomNavigationBar(
                    destinations = mainDestinations,
                    currentDestination = currentDestination
                ) {
                    navHostController.navigateToTab(it)
                }
            }
        }
    ) {
        MyNavHost(navController = navHostController)
    }
}

@Composable
fun BottomNavigationBar(
    destinations: List<DestinationProtocol>,
    currentDestination: NavDestination?,
    onMenuClick: (DestinationProtocol) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ),
        containerColor = Color.White
    ) {
        destinations.forEach { destination ->
            BottomNavigationItem(
                isSelected = currentDestination.isSelectedTab(destination),
                destination = destination
            ) {
                onMenuClick(destination)
            }
        }
    }
}

@Composable
fun RowScope.BottomNavigationItem(
    isSelected: Boolean,
    destination: DestinationProtocol,
    onMenuClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onMenuClick,
        icon = {
            Icon(
                imageVector = if (isSelected) destination.selectedIcon else destination.unselectedIcon,
                contentDescription = null
            )
        },
        label = {
            Text(text = stringResource(id = destination.menuTitle))
        }
    )
}

private fun NavDestination?.isSelectedTab(destination: DestinationProtocol): Boolean {
    return this?.hierarchy?.any {
        it.route == destination.route
    } ?: false
}
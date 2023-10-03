package com.csergio.composepractice.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.composepractice.navigation.MyNavHost
import com.csergio.composepractice.navigation.NavigationHelper
import com.csergio.composepractice.navigation.NavigationHelper.findDestination
import com.csergio.composepractice.navigation.NavigationHelper.navigateToTab
import com.csergio.composepractice.navigation.mainDestinations

@Composable
fun MyApp(navHostController: NavHostController = rememberNavController()) {
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    println("현재 위치 : ${currentDestination?.label} / $currentDestination")
    val showSystemBars = NavigationHelper.showSystemBars(currentDestination?.route)
    Scaffold(
        topBar = {
            if (showSystemBars) {
                TopAppBar(currentDestination, navHostController)
            }
        },
        bottomBar = {
            if (showSystemBars) {
                BottomNavigationBar(
                    destinations = mainDestinations,
                    currentDestination = currentDestination
                ) {
                    navHostController.navigateToTab(it)
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MyNavHost(navController = navHostController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    destinations: List<DestinationProtocol>,
    currentDestination: NavDestination?,
    onMenuClick: (DestinationProtocol) -> Unit,
) {
    NavigationBar() {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    currentDestination: NavDestination?,
    navController: NavController
) {
    val destination = currentDestination?.findDestination()
    val isMain = NavigationHelper.isMain(currentDestination)
    CenterAlignedTopAppBar(
        title = {
            destination?.appBarTitle?.let { title ->
                Text(text = stringResource(id = title))
            }
        },
        navigationIcon = {
            if (isMain.not()) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}
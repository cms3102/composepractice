package com.csergio.composepractice.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csergio.composepractice.navigation.MainDestination
import com.csergio.composepractice.navigation.MyNavHost
import com.csergio.composepractice.navigation.NavigationHelper
import com.csergio.composepractice.navigation.navigateToTab

@Composable
fun MyApp(navHostController: NavHostController = rememberNavController()) {
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    println("현재 위치 : ${currentDestination?.label} / $currentDestination")
    val showSystemBars = NavigationHelper.showSystemBars(currentDestination?.route)
    Scaffold(
        topBar = {
            if (showSystemBars) {
                TopAppBar("앱바 타이틀")
            }
        },
        bottomBar = {
            if (showSystemBars) {
                BottomNavigationBar(
                    destinations = MainDestination.values().toList(),
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
    destinations: List<MainDestination>,
    currentDestination: NavDestination?,
    onMenuClick: (MainDestination) -> Unit,
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
    destination: MainDestination,
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

private fun NavDestination?.isSelectedTab(destination: MainDestination): Boolean {
    println("선택1 : ${this?.hierarchy}")
    println("선택2 : $destination")
    println("선택3 : ${
        this?.hierarchy?.any {
            println("선택4 : ${it.route}")
            it.route?.contains(destination.name, true) ?: false
        }
    }")
    return this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
    )
}
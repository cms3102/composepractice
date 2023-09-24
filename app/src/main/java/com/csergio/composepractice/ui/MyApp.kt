package com.csergio.composepractice.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csergio.composepractice.navigation.MyNavHost
import com.csergio.composepractice.navigation.NavigationHelper

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
                BottomNavigationBar()
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MyNavHost(navController = navHostController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
    )
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(

    ) {
        Text(text = "이게 맞니")
    }
}
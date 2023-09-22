package com.csergio.composepractice.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Surface
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.csergio.composepractice.navigation.MyNavHost
import com.csergio.introduce.IntroduceScreen
import com.csergio.login.LoginScreen

@Composable
fun MyApp(navHostController: NavHostController) {
    println("현재 위치 : ${navHostController.currentDestination}")
    Scaffold(
        topBar = {
            TopAppBar("앱바 타이틀")
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MyNavHost(navController = navHostController)
        }
//        var loginState by remember { mutableStateOf(false) }
//        Crossfade(
//            targetState = loginState,
//            label = "",
//            modifier = Modifier.padding(paddingValues)
//        ) { isLogin ->
//            if (isLogin) {
//                IntroduceScreen {
//
//                }
//            } else {
//                LoginScreen {
//                    loginState = true
//                }
//            }
//        }
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
    NavigationBar {
        Text(text = "이게 맞니")
    }
}
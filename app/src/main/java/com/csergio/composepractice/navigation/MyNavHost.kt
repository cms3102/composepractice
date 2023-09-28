package com.csergio.composepractice.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.csergio.citydata.navigation.cityDataScreen
import com.csergio.citydata.navigation.navigateToCityData
import com.csergio.citydata.viewmodel.CityDataViewModel
import com.csergio.introduce.navigation.introduceScreen
import com.csergio.introduce.navigation.navigateToIntroduce
import com.csergio.login.navigation.loginRoute
import com.csergio.login.navigation.loginScreen
import com.csergio.login.navigation.navigateToLogin

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyNavHost(
    navController: NavHostController
) {
    var loginState by remember { mutableStateOf(false) }
    NavHost(
        navController = navController,
        startDestination = loginRoute,
    ) {
        loginScreen {
            loginState = true
            navController.navigateToIntroduce()
        }
        introduceScreen {
            navController.navigateToCityData()
        }
        cityDataScreen()
    }
}
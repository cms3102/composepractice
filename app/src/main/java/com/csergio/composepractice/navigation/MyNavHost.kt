package com.csergio.composepractice.navigation

import android.net.Uri
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.csergio.tour.navigation.tourScreen
import com.csergio.tour.navigation.navigateToTour
import com.csergio.introduce.navigation.introduceScreen
import com.csergio.introduce.navigation.navigateToIntroduce
import com.csergio.login.navigation.loginRoute
import com.csergio.login.navigation.loginScreen
import com.csergio.settings.navigation.settingsScreen
import com.csergio.tour.navigation.navigateToTourDetail
import com.csergio.tour.navigation.tourDetailScreen
import com.google.gson.Gson

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
            navController.navigateToTour()
        }
        tourScreen { tourData ->
            val dataJson = Gson().toJson(tourData)
            val dataUri = Uri.encode(dataJson)
            navController.navigateToTourDetail(dataUri)
        }
        tourDetailScreen()
        settingsScreen()
    }
}
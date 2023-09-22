package com.csergio.introduce.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.csergio.introduce.IntroduceScreen

const val introduceRoute = "introduce_route"

fun NavController.navigateToIntroduce() {
    navigate(introduceRoute)
}

fun NavGraphBuilder.introduceScreen(onFinished: () -> Unit) {
    composable(
        route = introduceRoute
    ) {
        IntroduceScreen {
            onFinished.invoke()
        }
    }
}
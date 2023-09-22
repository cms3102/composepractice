package com.csergio.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.csergio.login.LoginScreen

const val loginRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(onLogin: () -> Unit) {
    composable(loginRoute) {
        LoginScreen {
            onLogin.invoke()
        }
    }
}
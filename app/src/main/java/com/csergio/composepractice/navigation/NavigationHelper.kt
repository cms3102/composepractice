package com.csergio.composepractice.navigation

import com.csergio.introduce.navigation.introduceRoute
import com.csergio.login.navigation.loginRoute

object NavigationHelper {
    fun showSystemBars(route: String?): Boolean {
        return route != loginRoute && route != introduceRoute
    }

}
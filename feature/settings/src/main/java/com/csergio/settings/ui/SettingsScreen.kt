package com.csergio.settings.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.csergio.common.ui.MyScaffold
import com.csergio.settings.navigation.Settings

@Composable
fun SettingsScreen(navController: NavController) {
    MyScaffold(
        navController = navController,
        destination = Settings
    ) {
        val menus = SettingMenu.values().toList()
        LazyColumn() {
            items(menus) {
                SettingItem(
                    type = it
                )
            }
        }
    }
}
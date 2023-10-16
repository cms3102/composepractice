package com.csergio.settings.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.csergio.common.ui.MyScaffold
import com.csergio.settings.navigation.Settings
import com.csergio.settings.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
) {
    MyScaffold(
        navController = navController,
        destination = Settings
    ) {
        val menus = SettingMenu.values().toList()
        LazyColumn() {
            items(menus) { menu ->
                SettingItem(type = menu) { switched ->
                    when(menu) {
                        SettingMenu.ThemeMode -> {
                            if (switched) {

                            } else {

                            }
                        }
                    }
                }
            }
        }
    }
}
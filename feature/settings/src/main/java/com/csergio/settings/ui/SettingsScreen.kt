package com.csergio.settings.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.csergio.common.ui.MyScaffold
import com.csergio.settings.navigation.Settings
import com.csergio.settings.viewmodel.SettingsViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    MyScaffold(
        navController = navController,
        destination = Settings
    ) {
        val menus = SettingMenu.values().toList()
        LazyColumn() {
            items(menus) { menu ->
                SettingItem(
                    type = menu
                ) { switched ->
                    when(menu) {
                        SettingMenu.ThemeMode -> {
                            viewModel.saveThemeSetting(switched)
                        }
                    }
                }
            }
        }
    }
}
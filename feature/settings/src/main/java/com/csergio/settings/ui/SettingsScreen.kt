package com.csergio.settings.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.csergio.common.ui.MyScaffold
import com.csergio.settings.navigation.Settings
import com.csergio.settings.viewmodel.SettingsViewModel
import kotlinx.coroutines.coroutineScope

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    var themeSwitchState by remember { mutableStateOf(viewModel.isDarkThemeState.value) }
    MyScaffold(
        navController = navController,
        destination = Settings
    ) {
        val menus = SettingMenu.values().toList()
        LazyColumn() {
            items(menus) { menu ->
                SettingItem(
                    type = menu,
                    switched = themeSwitchState
                ) { switched ->
                    when(menu) {
                        SettingMenu.ThemeMode -> {
                            themeSwitchState = switched
                            viewModel.saveThemeSetting(switched)
                        }
                    }
                }
            }
        }
    }
}
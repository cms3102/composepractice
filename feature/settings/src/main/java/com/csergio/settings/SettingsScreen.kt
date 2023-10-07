package com.csergio.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.csergio.common.ui.MyScaffold
import com.csergio.settings.navigation.Settings

@Composable
fun SettingsScreen(navController: NavController) {
    MyScaffold(
        navController = navController,
        destination = Settings
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "설정 화면")
        }
    }
}
package com.csergio.settings.ui

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.csergio.common.theme.PaddingDefaults
import com.csergio.feature.settings.R

enum class SettingMenu {
    ThemeMode
}

@Composable
fun SettingItem(
    type: SettingMenu,
    onClick: (switched: Boolean) -> Unit = {},
) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.3f))
            .height(10.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = PaddingDefaults.paddingHorizontal),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val name: String
        var isButton: Boolean = true
        val icon: ImageVector
        var switched by remember { mutableStateOf(false) }
        when(type) {
            SettingMenu.ThemeMode -> {
                name = stringResource(id = R.string.setting_menu_theme)
                isButton = false
                icon = Icons.Default.KeyboardArrowRight
            }
        }
        Text(
            modifier = Modifier.weight(1f),
            text = name
        )
        if (isButton) {
            IconButton(onClick = { onClick(switched) }) {
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
            }
        } else {
            Switch(
                checked = switched ?: false,
                onCheckedChange = { isSwitched ->
                    switched = isSwitched
                    onClick(isSwitched)
                }
            )
        }
    }
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.3f))
            .height(10.dp)
    )
}
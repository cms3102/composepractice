package com.csergio.common.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object PaddingDefaults {
    val paddingHorizontal = 16.dp
}

object SpaceDefaults {
    val verticalSpace = 10.dp
    val verticalSpacer: @Composable () -> Unit = {
        Spacer(modifier = Modifier.height(verticalSpace))
    }
}


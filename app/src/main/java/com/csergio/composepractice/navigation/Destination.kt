package com.csergio.composepractice.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.composepractice.R
import com.csergio.map.navigation.GoogleMap
import com.csergio.settings.navigation.Settings
import com.csergio.tour.navigation.Tour
import com.csergio.tour.navigation.TourDetail

internal val mainDestinations = listOf(
    Tour,
    GoogleMap,
    Undefined,
    Settings
)

internal val destinations = listOf(
    Tour,
    TourDetail,
    GoogleMap,
    Undefined,
    Settings
)

object Undefined : DestinationProtocol {
    override val selectedIcon: ImageVector = Icons.Filled.AddCircle
    override val unselectedIcon: ImageVector = Icons.Outlined.AddCircle
    override val menuTitle: Int = R.string.undefined_title
    override val appBarTitle: Int = R.string.undefined_app_bar_title
    override val route: String = "undefined_route"
    override val isMain: Boolean = true
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun undefinedMessageDialog(onDismissRequest: () -> Unit) {
    AlertDialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .size(100.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.undefined_snackbar_message),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



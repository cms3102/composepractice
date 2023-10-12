package com.csergio.composepractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.csergio.common.protocol.DestinationProtocol
import com.csergio.common.ui.MyScaffold
import com.csergio.composepractice.R
import com.csergio.composepractice.navigation.MyNavHost
import com.csergio.composepractice.navigation.NavigationHelper
import com.csergio.composepractice.navigation.NavigationHelper.findDestination
import com.csergio.composepractice.navigation.NavigationHelper.navigateToTab
import com.csergio.composepractice.navigation.Undefined
import com.csergio.composepractice.navigation.mainDestinations
import com.csergio.composepractice.navigation.undefinedMessageDialog
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(navHostController: NavHostController = rememberNavController()) {

    var dialogState by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    if (dialogState) {
        undefinedMessageDialog {
            dialogState = false
        }
    }

    MyScaffold(
        navController = navHostController,
        snackbarHostState = snackbarHostState,
        bottomBar = {
            val backStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = backStackEntry?.destination
            val show = currentDestination?.findDestination()?.isMain ?: false
            val undefinedMessage = LocalContext.current.getString(R.string.undefined_snackbar_message)

            if (show) {
                BottomNavigationBar(
                    destinations = mainDestinations,
                    currentDestination = currentDestination,
                ) { destination ->
                    if (destination.route == Undefined.route) {
                        dialogState = true
//                        coroutineScope.launch {
//                            snackbarHostState.showSnackbar(message = undefinedMessage)
//                        }
                    } else {
                        navHostController.navigateToTab(destination)
                    }
                }
            }
        }
    ) {
        MyNavHost(navController = navHostController)
    }
}

@Composable
fun BottomNavigationBar(
    destinations: List<DestinationProtocol>,
    currentDestination: NavDestination?,
    onMenuClick: (DestinationProtocol) -> Unit,
) {
    NavigationBar(
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ),
        containerColor = Color.White
    ) {
        destinations.forEach { destination ->
            BottomNavigationItem(
                isSelected = currentDestination.isSelectedTab(destination),
                destination = destination
            ) {
                onMenuClick(destination)
            }
        }
    }
}

@Composable
fun RowScope.BottomNavigationItem(
    isSelected: Boolean,
    destination: DestinationProtocol,
    onMenuClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onMenuClick,
        icon = {
            Icon(
                imageVector = if (isSelected) destination.selectedIcon else destination.unselectedIcon,
                contentDescription = null
            )
        },
        label = {
            Text(text = stringResource(id = destination.menuTitle))
        }
    )
}

private fun NavDestination?.isSelectedTab(destination: DestinationProtocol): Boolean {
    return this?.hierarchy?.any {
        it.route == destination.route
    } ?: false
}
package com.csergio.common.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.csergio.common.protocol.DestinationProtocol

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    navController: NavController,
    destination: DestinationProtocol?,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        title = {
            destination?.appBarTitle?.run {
                Text(text = stringResource(id = this))
            }
        },
        navigationIcon = {
            if (destination?.isMain == false) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MyScaffold(
    navController: NavController,
    snackbarHostState: SnackbarHostState? = null,
    destination: DestinationProtocol? = null,
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val showTopAppBar = destination != null
    Scaffold(
        modifier = if (showTopAppBar) {
            Modifier.nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
        } else {
            Modifier
        },
        topBar = topBar ?: {
            if (showTopAppBar) {
                MyTopAppBar(navController, destination, topAppBarScrollBehavior)
            }
        },
        bottomBar = bottomBar,
        snackbarHost = {
            snackbarHostState?.let { SnackbarHost(hostState = it) }
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
            ) {
                content()
            }
        }
    )
}
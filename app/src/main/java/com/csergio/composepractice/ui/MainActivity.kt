package com.csergio.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.csergio.common.theme.ComposePracticeTheme
import com.csergio.composepractice.viewmodel.MainViewModel
import com.csergio.composepractice.viewmodel.SplashState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
//        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(Color.RED, Color.BLUE)
//        )
        super.onCreate(savedInstanceState)

        var splashState by mutableStateOf<SplashState>(SplashState.Showing)
        splashScreen.setKeepOnScreenCondition {
            when(splashState) {
                SplashState.Showing -> true
                else -> false
            }
        }

        lifecycleScope.launch {
            delay(1000)
            splashState = SplashState.Finished
        }

        setContent {
            ComposePracticeTheme(
                darkTheme = viewModel.isDarkTheme.collectAsState(initial = false).value,
                dynamicColor = false
            ) {
                MyApp(windowSizeClass = calculateWindowSizeClass(this))
            }
        }
    }
}


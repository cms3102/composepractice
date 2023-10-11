package com.csergio.composepractice

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.csergio.composepractice.ui.MyApp
import com.csergio.common.theme.ComposePracticeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

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
            ComposePracticeTheme {
                MyApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        MyApp(rememberNavController())
    }
}
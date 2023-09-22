package com.csergio.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.csergio.composepractice.ui.MyApp
import com.csergio.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                MyApp(rememberNavController())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    com.csergio.theme.ComposePracticeTheme {
        MyApp(rememberNavController())
    }
}
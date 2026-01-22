package dev.marcosalis.clean.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.marcosalis.clean.ui.navigation.AppHost
import dev.marcosalis.clean.ui.theme.CleanArchitectureAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            CleanArchitectureAppTheme {
                AppHost()
            }
        }
    }
}

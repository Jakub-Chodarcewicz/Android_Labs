package com.example.szablon

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.szablon.ui.theme.SzablonTheme
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


class MainApplication : Application() {
    @Composable
    fun MyApp() {
        val navController = rememberNavController()
        SzablonTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NavGraph(navController = navController)
            }
        }
    }
}

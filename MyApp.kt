package com.example.szablon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class SharedViewModel : ViewModel() {
    var counter by mutableStateOf(0)
        private set

    fun incrementCounter() {
        counter++
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = "screen1"
) {
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navController, startDestination = startDestination) {
        addScreens(navController, sharedViewModel)
        addScreens(navController, sharedViewModel)
    }
}

private fun NavGraphBuilder.addScreens(
    navController: NavHostController,
    sharedViewModel: SharedViewModel) {
    composable("screen1") {
        Screen1(navController = navController, sharedViewModel = sharedViewModel)
    }
    composable(
        "screen2/{counter}",
        arguments = listOf(navArgument("counter") { type = NavType.IntType })
    ) { backStackEntry ->
        Screen2(
            navController = navController,
            sharedViewModel = sharedViewModel,
            counter = backStackEntry.arguments?.getInt("counter") ?: 0
        )
    }
    composable(
        "screen3/{counter}",
        arguments = listOf(navArgument("counter") { type = NavType.IntType })
    ) { backStackEntry ->
        Screen3(
            navController = navController,
            sharedViewModel = sharedViewModel,
            counter = backStackEntry.arguments?.getInt("counter") ?: 0
        )
    }
    // Add more screens as needed
}
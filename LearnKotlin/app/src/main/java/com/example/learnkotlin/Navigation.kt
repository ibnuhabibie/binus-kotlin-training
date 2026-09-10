package com.example.learnkotlin

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learnkotlin.ui.screen.DetailScreen
import com.example.learnkotlin.ui.screen.MainScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument(
                    name = "name",
                    builder = {
                        type = NavType.StringType
                        defaultValue = ""
                        nullable = false
                    }
                )
            )
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
            )
        }
    }
}
package com.example.currencyconverter

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.currencyconverter.ui.screen.MainScreen
import com.example.currencyconverter.ui.screen.SplashScreen

@Composable
fun Navigation() {
    var navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}
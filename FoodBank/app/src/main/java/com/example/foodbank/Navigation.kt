package com.example.foodbank

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodbank.ui.screen.DetailScreen
import com.example.foodbank.ui.screen.MainScreen
import com.example.foodbank.ui.viewmodel.FoodBankViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: FoodBankViewModel = FoodBankViewModel()

    NavHost(navController = navController, startDestination = Screen.MainScreen.Route) {
        composable(
            route = Screen.MainScreen.Route
        ) {
            MainScreen(navController, viewModel)
        }
        composable(
            route = Screen.DetailScreen.Route
        ) {
            DetailScreen(navController, viewModel)
        }
    }
}
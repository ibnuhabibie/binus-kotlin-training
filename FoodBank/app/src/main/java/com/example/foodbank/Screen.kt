package com.example.foodbank

sealed class Screen(val Route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
}
package com.example.expandmalangtest.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Explore : Screen("explore")
    object MyTrips : Screen("my_trips")
    object Profile : Screen("profile")
}

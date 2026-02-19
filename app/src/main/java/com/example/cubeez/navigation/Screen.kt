package com.example.cubeez.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
    object Step: Screen("step_screen")
}
package com.example.cubeez.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.RoomDatabase
import com.example.cubeez.database.CubeDatabase
import com.example.cubeez.navigation.Screen.Home
import com.example.cubeez.navigation.Screen.Step
import com.example.cubeez.ui.detail.DetailScreen
import com.example.cubeez.ui.home.HomeScreen
import com.example.cubeez.viewmodel.StepViewModel

@Composable
fun CubeAppNavigation(stepViewModel: StepViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(navController = navController, viewModel = stepViewModel)
        }
        composable(
            route = Step.route + "/{stepId}",
            arguments = listOf(
                navArgument("stepId") { type = NavType.IntType }
            )
        ) {
            val stepId = it.arguments!!.getInt("stepId")
            DetailScreen(
                stepId = stepId,
                navController = navController,
                stepViewModel = stepViewModel,
            )
        }
    }
}

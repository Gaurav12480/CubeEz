package com.example.cubeez.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cubeez.navigation.Screen.Home
import com.example.cubeez.navigation.Screen.Step
import com.example.cubeez.ui.home.HomeScreen
import com.example.cubeez.ui.step.StepScreen

@Composable
fun CubeAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Step.route + "/{stepName}/{stepId}",
            arguments = listOf(
                navArgument("stepName") { type = NavType.StringType },
                navArgument("stepId") { type = NavType.IntType }
            )
        ) {
            val stepName = it.arguments?.getString("stepName")
            val stepId = it.arguments?.getInt("stepId")
            StepScreen(
                stepId = stepId,
                stepName = stepName,
                navController = navController
            )
        }
    }
}
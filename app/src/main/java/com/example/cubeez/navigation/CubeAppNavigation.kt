package com.example.cubeez.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cubeez.navigation.Screen.Home
import com.example.cubeez.navigation.Screen.Step
import com.example.cubeez.ui.detail.DetailScreen
import com.example.cubeez.ui.home.HomeScreen
import com.example.cubeez.viewmodel.CubeViewModel

@Composable
fun CubeAppNavigation(cubeViewModel: CubeViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(
                navController = navController,
                cubeViewModel = cubeViewModel,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
            )
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
                cubeViewModel = cubeViewModel,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .safeDrawingPadding()
            )
        }
    }
}

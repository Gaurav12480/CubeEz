package com.example.cubeez.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cubeez.navigation.Screen
import com.example.cubeez.viewmodel.CubeViewModel


@Composable
fun HomeScreen(modifier: Modifier = Modifier, cubeViewModel: CubeViewModel, navController: NavController) {
    val progress by cubeViewModel.getProgress().collectAsState(0f)
    val steps by cubeViewModel.steps.collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = { HomeScreenTopAppBar() }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyVerticalGrid (
                columns = GridCells.Adaptive(300.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(steps) {
                    val isStepCompleted = cubeViewModel.isStepCompleted(it.stepId).collectAsState(false).value
                    StepCard(
                        checked = isStepCompleted,
                        step = it,
                        onClick = {
                            navController.navigate(Screen.Step.route +"/${it.stepId}")
                        }
                    )
                }
            }
            ProgressBar(progress)
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
//    HomeScreen()
}
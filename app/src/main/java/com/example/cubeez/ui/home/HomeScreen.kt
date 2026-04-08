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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeScreenViewModel = viewModel()) {
    val progress by remember { mutableFloatStateOf(0.5f) }
    val steps by viewModel.steps.collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding(),
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
                    StepCard(
                        checked = true,     //TEMPORARY
                        step = it,
                        onClick = {}
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
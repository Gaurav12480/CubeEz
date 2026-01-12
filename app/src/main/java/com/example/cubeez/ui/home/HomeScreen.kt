package com.example.cubeez.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.5f) }
    Column (
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(12.dp),
        ) {
            items(10) {
                StepCard(checked = true)
            }
        }
        ProgressBar(progress)
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
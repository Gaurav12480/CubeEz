package com.example.cubeez.ui.step

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cubeez.R

@SuppressLint("ConfigurationScreenWidthHeight")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun StepScreen(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current

    val isLandscape =
        configuration.screenWidthDp > configuration.screenHeightDp
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = { StepScreenTopAppBar(1) }
    ) {
        paddingValues ->

        if (isLandscape) {
            LazyRow(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(paddingValues),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                items(10) {
                    CaseCard(
                        R.drawable.blankcube,
                        R.string.s1,
                        R.string.s1_des,
                        true
                    )
                }
            }
        }
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) {
                    CaseCard(
                        R.drawable.blankcube,
                        R.string.s1,
                        R.string.s1_des,
                        true
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun StepScreenPreview() {
    StepScreen()
}



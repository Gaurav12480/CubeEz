package com.example.cubeez.ui.step

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cubeez.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun StepScreen(
    stepName: Int,
    stepDescription: Int,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.screenWidthDp > configuration.screenHeightDp

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { StepScreenTopAppBar(1) }
    ) { paddingValues ->

        if (isLandscape) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(stepName),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = stringResource(stepDescription),
                    style = MaterialTheme.typography.bodyMedium

                )

                LazyRow(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
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

        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                item {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = stringResource(stepName),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(stepDescription),
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
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
    StepScreen(R.string.s1, stepDescription = R.string.s1_des)
}

package com.example.cubeez.ui.detail

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cubeez.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun DetailScreen(
    stepName: String?,
    stepId: Int?,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.screenWidthDp > configuration.screenHeightDp

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { DetailScreenTopAppBar(currentStep = stepId ?: 0 , onClick = { navController.popBackStack() }) }
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

                if (stepName != null && stepId != null) {
                    Text(
                        text = stepName,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Step: $stepId",
                        style = MaterialTheme.typography.bodyMedium

                    )
                }

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
                        if (stepName != null && stepId != null) {
                            Text(
                                text = stepName,
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Step: $stepId",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
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
private fun DetailScreenPreview() {
//    StepScreen(stringResource(R.string.s1), 101)
}

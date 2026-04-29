package com.example.cubeez.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cubeez.viewmodel.StepViewModel

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun DetailScreen(
    stepId: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StepViewModel = viewModel()
) {

    val steps by viewModel.steps.collectAsState()
    val step = steps.find { it.stepId == stepId }
    val stepName = step?.stepName
    val stepDescription = step?.stepDescription


    val configuration = LocalConfiguration.current
    val isLandscape =
        configuration.screenWidthDp > configuration.screenHeightDp

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { DetailScreenTopAppBar(currentStep = stepId, onClick = { navController.popBackStack() }) }
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
                    text = stepName?: "",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = stepDescription?: "",
                    style = MaterialTheme.typography.bodyMedium
                )

                LazyRow(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(step?.cases ?: emptyList()) {
                        CaseCard(
                            image = it.caseImage,
                            title = it.caseId,
                            description = it.caseDescription,
                            checked = true
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
                            text = stepName?: "",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stepDescription?: "",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                items(step?.cases ?: emptyList()) {
                    CaseCard(
                        image = it.caseImage,
                        title = it.caseId,
                        description = it.caseDescription,
                        checked = true
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

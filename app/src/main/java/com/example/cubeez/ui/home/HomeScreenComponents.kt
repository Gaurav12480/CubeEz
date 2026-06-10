package com.example.cubeez.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cubeez.R
import com.example.cubeez.model.Step
import com.example.cubeez.ui.components.CircularCheckbox
import com.example.cubeez.ui.theme.CheckboxGreen
import com.example.cubeez.ui.theme.backgroundColor
import com.example.cubeez.ui.theme.progressColor

val clipShape: Shape = RoundedCornerShape(16.dp)
@Composable
fun ProgressBar(progress: Float, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp)
            .padding(horizontal = 8.dp)
            .clip(clipShape)
            .background(backgroundColor)
            .border(width = 4.dp, color = MaterialTheme.colorScheme.onBackground, shape = clipShape)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(progress)
                .background(progressColor)
        )
    }
}
@Composable
fun StepCard(
    checked: Boolean,
    step: Step,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.outline)
        ) {
            Row(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clickable(onClick = onClick)
                    .padding(12.dp)
                    ,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Step: " + step.stepId.toString(),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = step.stepName,
                        fontSize = 30.sp,
                        lineHeight = 32.sp
                    )
                }
                AsyncImage(
                    model = step.imageUrl,
                    contentDescription = step.stepName,
                    modifier = Modifier
                        .height(140.dp)
                    ,
                    contentScale = ContentScale.Fit
                )
            }
        }

        if (checked) {
            CircularCheckbox(
                checked = true,
                onCheckedChange = {  },
                color = CheckboxGreen,
                modifier = Modifier.align(Alignment.TopEnd),
                enabled = false
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
        title = {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.cubeezlogo),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 48.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    )
}


@Preview
@Composable
private fun HomeScreenTopAppBarPreview() {
    HomeScreenTopAppBar()
}

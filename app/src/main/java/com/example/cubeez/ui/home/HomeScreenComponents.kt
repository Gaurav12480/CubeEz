package com.example.cubeez.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cubeez.R
import com.example.cubeez.ui.components.CircularCheckbox
import com.example.cubeez.ui.theme.CheckboxGreen
import com.example.cubeez.ui.theme.backgroundColor
import com.example.cubeez.ui.theme.progressColor
import com.sillydevices.compose.ui.AutoSizeText

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
fun StepCard(checked: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.Transparent),
    ) {

        Card(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxWidth()
                .padding(14.dp),
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            ) {

                Box (
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .fillMaxWidth(.64f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Step: 1",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .padding(start = 4.dp, top = 4.dp),
                    )
                    AutoSizeText(
                        text = "Orient yellow edges",
                        maxLines = 1,
                        maxFontSize = 60.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterStart)
                            .padding(start = 4.dp, top = 4.dp),
                    )
                }
                Spacer(Modifier.padding(horizontal = 4.dp))
                Image(
                    painter = painterResource(id = R.drawable.blankcube),
                    contentDescription = null,
                    modifier = Modifier.wrapContentSize(),
                    contentScale = ContentScale.Fit
                )
            }
        }
        if (checked) {
            CircularCheckbox(
                checked = true,
                onCheckedChange = null,
                color = CheckboxGreen,
                modifier = Modifier.align(alignment = Alignment.TopEnd)
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
                    contentDescription = null
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
fun StepCardPreview() {
    StepCard(checked = true)
}

@Preview
@Composable
private fun HomeScreenTopAppBarPreview() {
    HomeScreenTopAppBar()
}
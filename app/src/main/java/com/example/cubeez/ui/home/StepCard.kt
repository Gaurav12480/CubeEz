package com.example.cubeez.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cubeez.R
import com.example.cubeez.ui.components.CircularCheckbox
import com.example.cubeez.ui.theme.CheckboxGreen
import com.sillydevices.compose.ui.AutoSizeText

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
                            .padding(start = 4.dp, top = 4.dp)
                    )
                    AutoSizeText(
                        text = "Orient yellow edges",
                        maxLines = 1,
                        maxFontSize = 60.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterStart)
                            .padding(start = 4.dp, top = 4.dp)
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


@Preview
@Composable
fun StepCardPreview() {
    StepCard(checked = true)
}


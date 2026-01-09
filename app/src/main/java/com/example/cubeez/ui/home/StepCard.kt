package com.example.cubeez.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cubeez.R
import com.example.cubeez.ui.components.CircularCheckbox
import com.example.cubeez.ui.theme.CheckboxGreen

@Composable
fun StepCard(checked: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Transparent),
    ) {

        Card(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Row () {
                Column (
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .fillMaxWidth(.6f)
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    Text(
                        text = "Step: 1",
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Daisy",
                        fontSize = 40.sp
                    )
                }
                Spacer(Modifier.padding(horizontal = 4.dp))
                Image(
                    painter = painterResource(id = R.drawable.placeholder_image),
                    contentDescription = null,
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
        CircularCheckbox(
            checked = checked,
            onCheckedChange = null,
            color = CheckboxGreen,
            modifier = Modifier.align(alignment = Alignment.TopEnd)
        )
    }
}


@Preview
@Composable
fun StepCardPreview(modifier: Modifier = Modifier) {
    StepCard(checked = true)
}


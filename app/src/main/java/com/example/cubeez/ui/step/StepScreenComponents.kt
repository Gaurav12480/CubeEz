package com.example.cubeez.ui.step

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.cubeez.R

@Composable
fun CaseCard(
    image: Int,
    title: Int,
    description: Int,
    modifier: Modifier = Modifier,
) {
    var viewMode by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8))
            .border(width = 2.dp, color = MaterialTheme.colorScheme.outline, RoundedCornerShape(8))
            .wrapContentSize()
            .shadow(elevation = 8.dp)
            .clickable(onClick = { viewMode = true })
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(220.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.onPrimary)
                    .padding(4.dp)
                ,
                text = stringResource(title),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        if (viewMode) {
            CaseDialog(
                onDismiss = {},

                image = R.drawable.blankcube,
                title = R.string.s1_case1,
                description = R.string.s1_case1_D,
            )
        }
    }
}

@Composable
fun CaseDialog(
    onDismiss: () -> Unit,
    image: Int,
    title: Int,
    description: Int,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton (onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear",
                        )
                    }
                }

                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(260.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(title),
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = stringResource(description),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun CaseCardPreview() {
    CaseCard(
        R.drawable.blankcube,
        R.string.s1,
        R.string.s1_des
    )
}
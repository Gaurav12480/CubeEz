package com.example.cubeez.ui.step

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.cubeez.R
import com.example.cubeez.ui.components.CircularCheckbox
import com.example.cubeez.ui.theme.CheckboxGreen

@Composable
fun CaseCard(
    image: Int,
    title: Int,
    description: Int,
    checked: Boolean,
    modifier: Modifier = Modifier,
) {
    var viewMode by remember { mutableStateOf(false) }
    Box {
        Card(
            modifier = modifier
                .size(260.dp)
                .padding(16.dp)
                .clickable { viewMode = true },
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline
                ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onPrimary)
                        .padding(vertical = 4.dp),
                    text = stringResource(title),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
        if (checked) {
            CircularCheckbox(
                checked = true,
                onCheckedChange = null,
                color = CheckboxGreen,
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
            )
        }
    }
    if (viewMode) {
        CaseDialog(
            onDismiss = {},
            image = R.drawable.blankcube,
            title = R.string.s1_case1,
            description = description,
        )
    }
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CaseDialog(
    onDismiss: () -> Unit,
    image: Int,
    title: Int,
    description: Int,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = modifier
                .padding(16.dp)
        ) {
            if (isLandscape) {
                // Landscape
                Column (
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CircularCheckbox(
                            checked = false,
                            onCheckedChange = {},
                        )
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear",
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Top
                    ) {
                        Image(
                            painter = painterResource(image),
                            contentDescription = null,
                            modifier = Modifier.size(260.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = stringResource(title),
                                fontSize = 22.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )

                            Text(
                                text = stringResource(description),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }

            } else {
                //Portrait
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularCheckbox(
                            checked = false,
                            onCheckedChange = {},
                        )
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
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StepScreenTopAppBar(currentStep: Int, modifier: Modifier = Modifier, onClick: ()-> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.step_number_title, currentStep)
            )
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        }
    )
}

//@Preview
//@Composable
//private fun CaseCardPreview() {
//    Column (Modifier.fillMaxSize()) {
//        CaseCard(
//            R.drawable.blankcube,
//            R.string.s1,
//            R.string.s1_des,
//            true
//        )
//    }
//}
@Preview(widthDp = 800, heightDp = 300)
@Composable
private fun CaseDialogPreviewLandscape() {
    Column (Modifier.fillMaxSize()) {
        CaseDialog(
            onDismiss = {},
            R.drawable.blankcube,
            R.string.s1,
            R.string.s1_des
        )
    }
}
@Preview
@Composable
private fun CaseDialogPreview() {
    Column (Modifier.fillMaxSize()) {
        CaseDialog(
            onDismiss = {},
            R.drawable.blankcube,
            R.string.s1,
            R.string.s1_des
        )
    }
}

//@Preview
//@Composable
//private fun StepScreenTopAppBarPreview() {
//    StepScreenTopAppBar(currentStep = 1)
//}
package com.example.cubeez.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.example.cubeez.R
import com.example.cubeez.ui.components.CircularCheckbox
import com.example.cubeez.ui.theme.CheckboxGreen

@Composable
fun CaseCard(
    image: String?,
    title: Int?,
    checked: Boolean,
    onCheckedChange: () -> Unit,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Card(
            modifier = modifier
                .size(260.dp)
                .padding(16.dp)
                .clickable(onClick = onCardClick),
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
                AsyncImage(
                    model = image,
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
                    text = title.toString(),
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
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CaseDialog(
    onDismiss: () -> Unit,
    image: String?,
    title: Int?,
    description: String?,
    checked: Boolean,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = modifier
                .fillMaxWidth(0.8f)
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
                            checked = checked,
                            onCheckedChange = onCheckedChange,
                            color = CheckboxGreen
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
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        AsyncImage(
                            model = image,
                            contentDescription = null,
                            modifier = Modifier.weight(0.5f),
                            contentScale = ContentScale.Fit
                        )
                        Column (
                            modifier = Modifier
                                .weight(0.5f)
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Case: $title",
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center,

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            )

                            Text(
                                text = description ?: "",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
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
                            checked = checked,
                            onCheckedChange = onCheckedChange,
                            color = CheckboxGreen
                        )
                        IconButton (onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear",
                            )
                        }
                    }
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .aspectRatio(1f)
                            .align(Alignment.CenterHorizontally),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "Case: $title",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = description ?: "",
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
fun DetailScreenTopAppBar(currentStep: Int, modifier: Modifier = Modifier, onClick: ()-> Unit) {
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
//@Preview(widthDp = 800, heightDp = 300)
//@Composable
//private fun CaseDialogPreviewLandscape() {
//    Column (Modifier.fillMaxSize()) {
//        CaseDialog(
//            onDismiss = {},
//            R.drawable.blankcube,
//            R.string.s1,
//            R.string.s1_des
//        )
//    }
//}
//@Preview
//@Composable
//private fun CaseDialogPreview() {
//    Column (Modifier.fillMaxSize()) {
//        CaseDialog(
//            onDismiss = {},
//            R.drawable.blankcube,
//            R.string.s1,
//            R.string.s1_des
//        )
//    }
//}

//@Preview
//@Composable
//private fun StepScreenTopAppBarPreview() {
//    StepScreenTopAppBar(currentStep = 1)
//}
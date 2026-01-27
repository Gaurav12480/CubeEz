package com.example.cubeez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cubeez.ui.home.HomeScreen
import com.example.cubeez.ui.step.StepScreen
import com.example.cubeez.ui.theme.CubeEzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CubeEzTheme {
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CubeEzTheme {
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .safeDrawingPadding(),
        ) { padding ->
            HomeScreen(
                modifier = Modifier.padding(padding)
            )
        }
    }
}
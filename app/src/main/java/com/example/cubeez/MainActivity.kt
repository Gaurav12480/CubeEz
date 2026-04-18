package com.example.cubeez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cubeez.navigation.CubeAppNavigation
import com.example.cubeez.ui.theme.CubeEzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CubeEzTheme {
                CubeAppNavigation()
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    CubeEzTheme {
//        Scaffold(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.background)
//                .safeDrawingPadding(),
//        ) { padding ->
//            HomeScreen(
//                modifier = Modifier.padding(padding)
//            )
//        }
//    }
//}
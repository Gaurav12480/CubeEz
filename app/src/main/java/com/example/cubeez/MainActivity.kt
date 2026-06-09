package com.example.cubeez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.cubeez.api.api
import com.example.cubeez.database.CubeDatabase
import com.example.cubeez.navigation.CubeAppNavigation
import com.example.cubeez.repository.CubeRepository
import com.example.cubeez.ui.theme.CubeEzTheme
import com.example.cubeez.viewmodel.CubeViewModel
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room
            .databaseBuilder(applicationContext, CubeDatabase::class.java, "cube-db")
        val cubeViewModel = CubeViewModel(
            Dispatchers.IO,
            cubeRepository = CubeRepository(cubeDao = db.build().cubeDao(), api = api),
        )

        setContent {
            CubeEzTheme {
                CubeAppNavigation(cubeViewModel)
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
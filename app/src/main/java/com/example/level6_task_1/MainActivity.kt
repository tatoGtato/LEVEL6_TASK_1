package com.example.level6_task_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.level6_task_1.ui.screens.AddGameScreen
import com.example.level6_task_1.ui.screens.GameScreen
import com.example.level6_task_1.ui.screens.HomeScreen
import com.example.level6_task_1.ui.theme.LEVEL6_TASK_1Theme
import com.example.level6_task_1.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LEVEL6_TASK_1Theme {
                GameApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameApp() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        GameNavHost(navController, modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun GameNavHost(navController: NavHostController, modifier: Modifier = Modifier) {

    val viewModel: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = GameScreen.HomeScreen.route,
        modifier = modifier
    ) {
        composable(GameScreen.HomeScreen.route) {
            HomeScreen(navController, viewModel)
        }
        composable(GameScreen.AddGameScreen.route) {
            AddGameScreen(navController, viewModel)
        }
    }
}
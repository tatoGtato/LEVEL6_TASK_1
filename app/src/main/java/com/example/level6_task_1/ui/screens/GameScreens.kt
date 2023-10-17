package com.example.level6_task_1.ui.screens

sealed class GameScreen(
    val route: String
) {
    object HomeScreen: GameScreen("home_screen")
    object AddGameScreen: GameScreen("add_game_screen")
}
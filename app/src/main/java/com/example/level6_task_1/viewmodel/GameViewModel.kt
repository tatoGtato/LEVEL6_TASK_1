package com.example.level6_task_1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.level6_task_1.data.Game
import com.example.level6_task_1.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    val gameBacklog =
        gameRepository.getGames() // LiveData object exposes the games from the room database.

    /**
     * Insert a game into the repository.
     */
    fun insertGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.insert(game)
            }

        }
    }

    /**
     * Delete the game backlog from the repository.
     */
    fun deleteGameBacklog() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteAll()
            }
        }
    }

    /**
     * Delete a game from the repository.
     */
    fun deleteGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.delete(game)
            }
        }
    }
}
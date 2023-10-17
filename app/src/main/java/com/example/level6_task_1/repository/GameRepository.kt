package com.example.level6_task_1.repository

import android.content.Context
import com.example.level6_task_1.data.Game
import com.example.level6_task_1.db.GameDao
import com.example.level6_task_1.db.GameRoomDatabase

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun insert(game: Game) = gameDao.insert(game)

    suspend fun delete(game: Game) = gameDao.delete(game)

    fun getGames() = gameDao.getGames()

    suspend fun deleteAll() = gameDao.deleteAll()

}
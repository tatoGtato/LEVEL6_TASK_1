package com.example.level6_task_1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.level6_task_1.data.Game

@Dao
interface GameDao {

    @Query("SELECT * from game ORDER BY `release` ASC")
    fun getGames(): LiveData<List<Game>>

    @Insert
    suspend fun insert(game: Game)

    @Insert
    suspend fun insert(game: List<Game>)

    @Delete
    suspend fun delete(game: Game)

    @Query("DELETE from game")
    suspend fun deleteAll()

}
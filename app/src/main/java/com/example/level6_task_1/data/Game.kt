package com.example.level6_task_1.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "game")
data class Game(
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "release")
    var release: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
)
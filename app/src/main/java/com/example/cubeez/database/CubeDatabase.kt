package com.example.cubeez.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CompletedCase::class], version = 1, exportSchema = false)
abstract class CubeDatabase: RoomDatabase() {
    abstract fun cubeDao(): CubeDao
}
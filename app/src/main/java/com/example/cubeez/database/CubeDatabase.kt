package com.example.cubeez.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CompletedCase::class], version = 1)
abstract class CubeDatabase: RoomDatabase() {
    abstract fun cubeDao(): CubeDao
}
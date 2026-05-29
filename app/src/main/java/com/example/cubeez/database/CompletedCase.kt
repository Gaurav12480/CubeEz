package com.example.cubeez.database

import androidx.room.Entity

@Entity(
    primaryKeys = ["stepId", "caseId"],
)
data class CompletedCase(
    val stepId : Int,
    val caseId : Int,
)

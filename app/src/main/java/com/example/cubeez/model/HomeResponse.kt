package com.example.cubeez.model

data class HomeResponse(
    val steps: List<Step>
)

data class Step(
    val imageUrl: String,
    val stepId: Int,
    val stepName: String
)
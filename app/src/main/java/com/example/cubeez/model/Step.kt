package com.example.cubeez.model

data class Step(
    val cases: List<Case>,
    val imageUrl: String,
    val stepDescription: String,
    val stepId: Int,
    val stepName: String
) {

}
package com.example.cubeez.repository

import com.example.cubeez.api.CubeApi
import com.example.cubeez.model.Step

class CubeRepository(private val api: CubeApi) {
    suspend fun getSteps(): List<Step> {
        return api.getSteps().steps
    }
}

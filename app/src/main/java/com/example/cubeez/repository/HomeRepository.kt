package com.example.cubeez.repository

import com.example.cubeez.api.CubeApi
import com.example.cubeez.model.Step

class HomeRepository(private val api: CubeApi) {
    suspend fun getHomeSteps(): List<Step> {
        return api.getHome().steps
    }
}

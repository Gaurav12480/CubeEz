package com.example.cubeez.api

import com.example.cubeez.model.StepsResponse
import retrofit2.http.GET

interface CubeApi {
    @GET("steps.json")
    suspend fun getHome(): StepsResponse
}

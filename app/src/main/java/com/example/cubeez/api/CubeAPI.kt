package com.example.cubeez.api

import com.example.cubeez.model.HomeResponse
import retrofit2.http.GET

interface CubeApi {
    @GET("home.json")
    suspend fun getHome(): HomeResponse
}

package com.example.cubeez.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://raw.githubusercontent.com/Gaurav12480/cube-api/main/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val api: CubeApi = retrofit.create(CubeApi::class.java)

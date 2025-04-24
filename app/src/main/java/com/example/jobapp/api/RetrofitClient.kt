package com.example.jobapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    val api: JobApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://testapi.getlokalapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JobApiService::class.java)
    }

}
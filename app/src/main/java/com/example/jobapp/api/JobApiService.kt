package com.example.jobapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface JobApiService {
    @GET("common/jobs?")
    suspend fun getJobs(@Query("page") page: Int = 1): Response<JobResponse>
}
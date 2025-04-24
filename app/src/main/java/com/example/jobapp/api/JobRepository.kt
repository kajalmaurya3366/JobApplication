package com.example.jobapp.api

class JobRepository{
    suspend fun getJobs(page: Int = 1) = RetrofitClient.api.getJobs(page)
}
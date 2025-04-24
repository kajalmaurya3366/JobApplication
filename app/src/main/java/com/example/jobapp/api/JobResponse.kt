package com.example.jobapp.api

import com.google.gson.annotations.SerializedName

data class JobResponse(
    val success: Boolean,
    val message: String?,
    val data: List<Job>?)

data class Job(
    @SerializedName("company_name") val companyName: String,
    @SerializedName("job_title") val jobTitle: String,
    val location: String,
//    @SerializedName("min_salary") val minSalary: String,
//    @SerializedName("max_salary") val maxSalary: String,
//    @SerializedName("job_type") val jobType: String,
//    val qualification: String,
//    @SerializedName("contact_number") val contactNumber: String
)

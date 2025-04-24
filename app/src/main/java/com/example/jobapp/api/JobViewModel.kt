package com.example.jobapp.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class JobViewModel(private val repository: JobRepository) : ViewModel() {

    private val _jobs = MutableLiveData<List<Job>>()
    val jobs: LiveData<List<Job>> get() = _jobs

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        fetchJobs()
    }

    fun fetchJobs() {
        viewModelScope.launch {
            try {

                val mockJobs = listOf(
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "IIT/ NEET Foundation, high school",
                        "Faculty, High School, Primary & Pre-Primary Teachers, RROs, Marketing Executives wanted for Hms, IIT/ NEET Foundation",
                        "Suryapet"
                    ),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "IIT/ NEET Foundation, high school",
                        "Faculty, High School, Primary & Pre-Primary Teachers, RROs, Marketing Executives wanted for Hms, IIT/ NEET Foundation",
                        "Suryapet"
                    ),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "IIT/ NEET Foundation, high school",
                        "Faculty, High School, Primary & Pre-Primary Teachers, RROs, Marketing Executives wanted for Hms, IIT/ NEET Foundation",
                        "Suryapet"
                    ),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "IIT/ NEET Foundation, high school",
                        "Faculty, High School, Primary & Pre-Primary Teachers, RROs, Marketing Executives wanted for Hms, IIT/ NEET Foundation",
                        "Suryapet"
                    ),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "SK Services",
                        "Urgently wanted Catering Boys & Girls to work in 5 & 7 Star Hotels in Hyderabad, Packing Boys to work in Amazon, Flipkart companies",
                        "Hyderabad"
                    ),
                    Job("Local app", "Wanted Tele Sales Executives", "Hyderabad"),
                    Job(
                        "Satyam Home Care Services",
                        "Satyam Home Care Services wants nannies and ward boys for patient care, housework and cooking.",
                        "Hyderabad"
                    ),
                )
                _jobs.value = mockJobs

                // Comment this part out until API issue is fixed
                // val response = repository.getJobs()
                // if (response.isSuccessful) {
                //     _jobs.value = response.body()?.data ?: emptyList()
                // } else {
                //     Log.d("API_Error", "Error: ${response.code()} - ${response.message()}")
                // }
            } catch (e: Exception) {
                Log.e("API_Error", "Exception: ${e.message}")
                _error.value = "Failed to fetch jobs: ${e.message}"
            }
        }
    }
}

class JobViewModelFactory(private val repository: JobRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JobViewModel(repository) as T
    }
}

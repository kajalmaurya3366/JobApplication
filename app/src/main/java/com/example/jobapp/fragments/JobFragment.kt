package com.example.jobapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobapp.adapter.JobAdapter
import com.example.jobapp.api.JobRepository
import com.example.jobapp.api.JobViewModel
import com.example.jobapp.api.JobViewModelFactory
import com.example.jobapp.R
import com.example.jobapp.api.Job


class JobFragment : Fragment(){

    private lateinit var viewModel: JobViewModel
    private lateinit var adapter: JobAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_job, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = JobAdapter(
            emptyList(),
            onClick = {job -> Toast.makeText(requireContext(), job.companyName, Toast.LENGTH_SHORT).show()  },
            onBookmarkClick = {

                job,
                imageView ->


                    imageView.setColorFilter(resources.getColor(R.color.dark_blue))
                    Toast.makeText(requireContext(), "Bookmarked: ${job.jobTitle}", Toast.LENGTH_SHORT).show()


            }
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val repository = JobRepository()
        val factory = JobViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[JobViewModel::class.java]

        viewModel.jobs.observe(viewLifecycleOwner) {
            adapter.updateJobs(it)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            it?.let { errorMsg -> Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_SHORT).show() }
        }

        return view
    }


}
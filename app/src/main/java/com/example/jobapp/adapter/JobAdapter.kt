package com.example.jobapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobapp.api.Job
import com.example.jobapp.R

class JobAdapter (
    private var jobList: List<Job>,
    private val onClick: (Job) -> Unit,
    private val onBookmarkClick:(Job,ImageView) -> Unit
) : RecyclerView.Adapter<JobAdapter.JobViewHolder>(){
    private val bookmarkedJobs = mutableListOf<Job>()

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val companyName: TextView = view.findViewById(R.id.companyName)
        val jobTitle: TextView = view.findViewById(R.id.jobTitle)
        val location: TextView = view.findViewById(R.id.location)
        val ivBookmark:ImageView=view.findViewById(R.id.iv_bookmark)

        fun bind(job: Job,  isBookmarked: Boolean,onClick: (Job) -> Unit, onBookmarkClick: (Job,ImageView) -> Unit) {
            companyName.text = job.companyName
            jobTitle.text = job.jobTitle
            location.text = job.location

            ivBookmark.setColorFilter(
                if (isBookmarked) itemView.context.getColor(R.color.blue) else itemView.context.getColor(R.color.black)
            )
            itemView.setOnClickListener {
                onClick(job)
            }
            ivBookmark.setOnClickListener {
                onBookmarkClick(job, ivBookmark)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.job_item, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        val isBookmarked = bookmarkedJobs.contains(job)
        Log.d("JobBinding", "Binding job: ${job.companyName}")
        holder.bind(job, isBookmarked, onClick, onBookmarkClick)

        holder.ivBookmark.setOnClickListener {
            onBookmarkClick(job,holder.ivBookmark)
        }
    }
    override fun getItemCount(): Int = jobList.size
    fun updateJobs(newJobs: List<Job>) {
        jobList = newJobs
        notifyDataSetChanged()
    }
}
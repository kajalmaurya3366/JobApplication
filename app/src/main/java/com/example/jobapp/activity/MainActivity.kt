package com.example.jobapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.jobapp.api.JobViewModel
import com.example.jobapp.R
import com.example.jobapp.adapter.JobAdapter
import com.example.jobapp.databinding.ActivityMainBinding
import com.example.jobapp.fragments.BookmarkFragment
import com.example.jobapp.fragments.JobFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: JobViewModel
    private lateinit var jobAdapter: JobAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_job ->
                {
                    val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment)
                    if (currentFragment !is JobFragment) {
                        replaceFragment(JobFragment())
                    }
                }
                R.id.bottom_bookmark -> replaceFragment(BookmarkFragment())
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}
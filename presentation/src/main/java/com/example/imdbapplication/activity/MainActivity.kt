package com.example.imdbapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbapplication.R
import com.example.imdbapplication.adapters.MainListAdapter
import com.example.imdbapplication.databinding.ActivityMainBinding
import com.example.imdbapplication.viewModel.MainViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    lateinit var mainListAdapter: MainListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.mainToolbar)
        initViewModel()
        initRecyclerView()
        initListeners()
    }

    private fun initListeners() {
        binding.mainRefreshTextView.setOnClickListener {
            binding.mainProgressBar.visibility = View.VISIBLE
            binding.mainRecyclerView.visibility = View.INVISIBLE
            mainViewModel.getMovieListFromApi()
        }
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        mainViewModel.movieListLiveData.observe(this, Observer {
            binding.mainProgressBar.visibility = View.VISIBLE
            mainListAdapter.submitList(it)
            binding.mainProgressBar.visibility = View.GONE
            binding.mainRecyclerView.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mainListAdapter = MainListAdapter()
        binding.mainRecyclerView.adapter = mainListAdapter
    }
}

package com.example.imdbapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
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
    private val mainViewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    lateinit var mainListAdapter: MainListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.mainToolbar)
        initDataBinding()
        initViewModel()
        initRecyclerView()
        initListeners()
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = this // Use viewLifeCycleOwner for fragments
        binding.viewModel = mainViewModel
    }

    private fun initListeners() {
        binding.mainRefreshTextView.setOnClickListener {
            mainViewModel.getMovieListFromApi()
        }
    }

    private fun initViewModel() {
//        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        // Use viewLifeCycleOwner for fragments
        mainViewModel.movieListLiveData.observe(this, Observer {
            mainListAdapter.submitList(it)
        })
    }

    private fun initRecyclerView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mainListAdapter = MainListAdapter()
        binding.mainRecyclerView.adapter = mainListAdapter
    }
}

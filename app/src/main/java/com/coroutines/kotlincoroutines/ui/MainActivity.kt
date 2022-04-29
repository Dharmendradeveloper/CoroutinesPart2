package com.coroutines.kotlincoroutines.ui

import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.coroutines.kotlincoroutines.R
import com.coroutines.kotlincoroutines.data.api.RetrofitAPI
import com.coroutines.kotlincoroutines.data.callback.APIService
import com.coroutines.kotlincoroutines.data.repository.MovieRepository
import com.coroutines.kotlincoroutines.databinding.ActivityMainBinding
import com.coroutines.kotlincoroutines.factory.MovieViewModelFactory
import com.coroutines.kotlincoroutines.ui.adapter.MovieAdapter
import com.coroutines.kotlincoroutines.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private val movieAdapter: MovieAdapter = MovieAdapter()
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.recycler.adapter = movieAdapter
        setInit()
    }

    fun setInit(){
        val apiService = RetrofitAPI.buildRetrofitAPIService(APIService::class.java)
        val repoInstance = MovieRepository(apiService)
        movieViewModel = ViewModelProvider(this,MovieViewModelFactory(repoInstance))
            .get(MovieViewModel::class.java)

        movieViewModel.movieList.observe(this,{
            Toast.makeText(this,"ddddddd",Toast.LENGTH_SHORT).show()
            movieAdapter.setMovie(it)
        })

        movieViewModel.errorMessage.observe(this,{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })

        movieViewModel.loading.observe(this,{
            if(it){
                binding.progressDialog.visibility = View.VISIBLE
            }else{
                binding.progressDialog.visibility = View.GONE
            }
        })

        movieViewModel.getAllMovies()
    }
}
package com.coroutines.kotlincoroutines.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coroutines.kotlincoroutines.data.repository.MovieRepository
import com.coroutines.kotlincoroutines.viewmodel.MovieViewModel
import java.lang.IllegalArgumentException

class MovieViewModelFactory constructor(private val repository: MovieRepository)
    :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            MovieViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}
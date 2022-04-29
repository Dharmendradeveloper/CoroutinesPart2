package com.coroutines.kotlincoroutines.data.repository

import com.coroutines.kotlincoroutines.data.api.RetrofitAPI
import com.coroutines.kotlincoroutines.data.callback.APIService
import com.coroutines.kotlincoroutines.data.model.MovieItem
import retrofit2.Response

class MovieRepository constructor(private val retrofitService:APIService) {
    suspend fun getAllMovies() = retrofitService.getAllMovies()
   /** suspend fun getMovie(): Response<MovieItem> {
        return retrofitService.getAllMovies()
    }*/
}
package com.coroutines.kotlincoroutines.data.callback

import com.coroutines.kotlincoroutines.data.model.MovieItem
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("movielist.json")
    suspend fun getAllMovies():Response<List<MovieItem>>
}
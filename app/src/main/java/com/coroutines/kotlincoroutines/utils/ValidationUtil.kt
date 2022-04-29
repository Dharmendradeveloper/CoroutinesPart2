package com.coroutines.kotlincoroutines.utils

import com.coroutines.kotlincoroutines.data.model.MovieItem

object ValidationUtil {

    fun validateMovie(movie:MovieItem):Boolean{
        if (movie.name.isNotEmpty()&&movie.category.isNotEmpty())
            return true
        return false
    }
}
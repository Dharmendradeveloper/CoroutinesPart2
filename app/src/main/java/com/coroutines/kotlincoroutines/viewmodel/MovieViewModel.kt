package com.coroutines.kotlincoroutines.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coroutines.kotlincoroutines.data.model.MovieItem
import com.coroutines.kotlincoroutines.data.repository.MovieRepository
import kotlinx.coroutines.*


class MovieViewModel constructor(private val repository: MovieRepository):ViewModel() {
    val movieList = MutableLiveData<List<MovieItem>>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    private val job:Job?=null
    private val exceptionHandler = CoroutineExceptionHandler{ _, throwable->{
        onErrorMessage("Exception Handler : ${throwable.localizedMessage}")
    }}

    fun getAllMovies(){
        CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            loading.postValue(true)//loading start
            val response = repository.getAllMovies()
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    movieList.postValue(response.body())//Some atkale
                    loading.value = false
                }else{
                    onErrorMessage("Error :${response.message()}")
                }
            }
        }
    }

    private fun onErrorMessage(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


}
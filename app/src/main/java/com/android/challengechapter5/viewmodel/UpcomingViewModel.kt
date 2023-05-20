package com.android.challengechapter5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.challengechapter5.model.UpcomingMovieIngfoh
import com.android.challengechapter5.model.UpcomingMovieItem
import com.android.challengechapter5.network.RestfulApi
import com.android.challengechapter5.network.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UpcomingViewModel @Inject constructor(
    private val movieClient: RestfulApi,
) : ViewModel() {
    private val _movie: MutableLiveData<List<UpcomingMovieItem>> = MutableLiveData()
    val movie: LiveData<List<UpcomingMovieItem>> get() = _movie

    fun callApiUpcoming() {
        movieClient.getUpcomingmovie()
            .enqueue(object : Callback<UpcomingMovieIngfoh> {
                override fun onResponse(
                    call: Call<UpcomingMovieIngfoh>,
                    response: Response<UpcomingMovieIngfoh>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            _movie.postValue(data.results as List<UpcomingMovieItem>?)
                        }
                    }
                }

                override fun onFailure(call: Call<UpcomingMovieIngfoh>, t: Throwable) {

                }

            })
    }
}
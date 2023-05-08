package com.android.challengechapter5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.challengechapter5.model.UpcomingMovieIngfoh
import com.android.challengechapter5.model.UpcomingMovieItem
import com.android.challengechapter5.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {
    var liveDataMovie: MutableLiveData<List<UpcomingMovieItem>?> = MutableLiveData()

    fun callApiUpcoming() {
        RetrofitClient.instance.getUpcomingmovie()
            .enqueue(object : Callback<UpcomingMovieIngfoh> {
            override fun onResponse(
                call: Call<UpcomingMovieIngfoh>,
                response: Response<UpcomingMovieIngfoh>
            ) {
                if (response.isSuccessful) {
                    liveDataMovie.postValue(response.body()?.results)
                } else {
                    liveDataMovie.postValue(null)
                }
            }

            override fun onFailure(call: Call<UpcomingMovieIngfoh>, t: Throwable) {
                liveDataMovie.postValue(null)
            }

        })
    }
}
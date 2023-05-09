package com.android.challengechapter5.network

import com.android.challengechapter5.model.UpcomingMovieIngfoh
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("movie/upcoming?api_key=42a15efc8e472e491d74c183c0dedc99&pages=1")
    fun getUpcomingmovie(): Call<UpcomingMovieIngfoh>
}
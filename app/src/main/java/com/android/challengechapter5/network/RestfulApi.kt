package com.android.challengechapter5.network

import com.android.challengechapter5.model.UpcomingMovieIngfoh
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {
    @GET("movie/upcoming?api_key=42a15efc8e472e491d74c183c0dedc99&pages=1")
    fun getUpcomingmovie(): Call<UpcomingMovieIngfoh>

//    @GET("top-headlines/sources")
//    fun getAllSources(
//        @Query("category") category : String,
//        @Query("apikey") apikey : String = "42a15efc8e472e491d74c183c0dedc99"
//    ) : Call<List<Source>>
}
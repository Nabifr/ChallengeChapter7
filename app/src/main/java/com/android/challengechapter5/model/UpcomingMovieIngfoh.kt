package com.android.challengechapter5.model


import com.google.gson.annotations.SerializedName

data class UpcomingMovieIngfoh(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<UpcomingMovieItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
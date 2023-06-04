package com.android.challengechapter5.model

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class UpcomingMovieItemTest{
    private lateinit var file: UpcomingMovieItem

    @Before
    fun persiapan() {
        // Inisialisasi dan mengelola objek-objek yang di-mock menggunakan framework Mockito
        MockitoAnnotations.openMocks(this)
        file = UpcomingMovieItem(
            true,
            "iniJalurBackdrop",
            listOf(1, 2, 3),
            14023,
            "swedish",
            "originalTitle",
            "overview",
            9.9,
            "posterPath",
            "2023-06-06",
            "Transformers: Rise of the Beasts",
            true,
            8.8,
            100
        )
    }

    @Test
    fun hasilTest() {
        // Persiapan file diharapkan (expected)
        assert(file.adult == false)
        assert(file.backdropPath == "iniJalurBackdrop")
        assert(file.genreIds == listOf(1, 2, 3))
        assert(file.id == 14023)
        assert(file.originalLanguage == "swedish")
        assert(file.originalTitle == "originalTitle")
        assert(file.overview == "overview")
        assert(file.popularity == 9.9)
        assert(file.posterPath == "posterPath")
        assert(file.releaseDate == "2023-06-06")
        assert(file.title == "Transformers: Rise of the Beasts")
        assert(file.video == true)
        assert(file.voteAverage == 8.8)
        assert(file.voteCount == 100)
    }
}
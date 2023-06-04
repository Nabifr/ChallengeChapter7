package com.android.challengechapter5.room

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FavDataTest {

    private lateinit var data: FavData

    @Before
    fun setUp() {
        data = FavData(
            id = 667538,
            title = "Transformers: Rise of the Beasts",
            releasedate = "2023-06-06",
            posterPath = "transformers.jpg",
        )
    }


    @Test
    //expected the test
    fun dataFavtest() {
        assertEquals(1, data.id)
        assertEquals("The Super Mario", data.title)
        assertEquals("2025-09-09", data.releasedate)
        assertEquals("poster.jpg", data.posterPath)

}}
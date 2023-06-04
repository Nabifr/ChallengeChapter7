package com.android.challengechapter5.model

import com.google.gson.Gson
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UpcomingMovieIngfohTest{

    private lateinit var gson: Gson

    @Before
    fun setup() {
        gson = Gson()
    }


    @Test
    fun testUpcomingMovieItem() {
        val json = """
            {
                "page": 1,
                "results": [
                    {
                        "id": 1,
                        "title": "Spider-Man: Across the Spider-Verse"
                    },
                    {
                        "id": 2,
                        "title": "The Flash"
                    }
                ],
                "total_pages": 12,
                "total_results": 236
            }
        """.trimIndent()

        //expected data

        val list = gson.fromJson(json, UpcomingMovieIngfoh::class.java)

        assertEquals(1, list.page)
        assertEquals(2, list.results.size)
        assertEquals(12, list.totalPages)
        assertEquals(236, list.totalResults)

        assertEquals(1, list.results[0].id)
        assertEquals("Spider-Man: Across the Spider-Verse", list.results[0].title)
        assertEquals(2, list.results[1].id)
        assertEquals("The Flash", list.results[1].title)
    }

}
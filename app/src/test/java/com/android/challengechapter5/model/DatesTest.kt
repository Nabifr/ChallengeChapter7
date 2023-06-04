package com.android.challengechapter5.model

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DatesTest {

    private lateinit var dates: Dates

    @Before
    //actual to input dates
    fun setActual() {
        val tanggal_max = "2023-06-26"
        val tanggal_min = "2023-06-08"

        dates = Dates(tanggal_max,tanggal_min)
    }


    @Test
    //expected
    fun testDates() {
        val tanggal_max = "2023-06-27"
        val tanggal_min = "2023-06-08"

        assertEquals(tanggal_max, dates.maximum)
        assertEquals(tanggal_min, dates.minimum)
    }
}
@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused"
)

package com.android.challengechapter5.model


import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused"
)
data class Dates(
    @SerializedName("maximum")
    val maximum: String,
    @SerializedName("minimum")
    val minimum: String
)
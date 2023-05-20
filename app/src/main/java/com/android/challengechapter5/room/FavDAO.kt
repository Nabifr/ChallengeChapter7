package com.android.challengechapter5.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavDAO {
    @Query("SELECT * FROM FavData")
    fun getAllFavorite() : List<FavData>

    @Delete
    fun deleteFavorite(favoriteMovie: FavData)

    @Insert
    fun addFavorite(favoriteMovie: FavData)

}
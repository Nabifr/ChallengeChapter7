package com.android.challengechapter5.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavData::class], version = 1)
abstract class FavDatabase : RoomDatabase(){
    abstract fun favDao(): FavDAO

}
package com.android.challengechapter5.network

import android.content.Context
import androidx.room.Room
import com.android.challengechapter5.room.FavDAO
import com.android.challengechapter5.room.FavDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {
    @Singleton
    @Provides
    fun getService(): RestfulApi {
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(RestfulApi::class.java)
}

    @Provides
        fun provideFavDAO(db : FavDatabase) : FavDAO = db.favDao()

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) : FavDatabase {
        return Room.databaseBuilder(context, FavDatabase::class.java, "favorite.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
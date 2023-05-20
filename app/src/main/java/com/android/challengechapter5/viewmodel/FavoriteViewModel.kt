package com.android.challengechapter5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.challengechapter5.room.FavDAO
import com.android.challengechapter5.room.FavData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(val db: FavDAO) : ViewModel() {
    private val _movie: MutableLiveData<FavData> = MutableLiveData()
    val movie: LiveData<FavData> get() = _movie
    private val _ListMovie: MutableLiveData<List<FavData>> = MutableLiveData()
    val listMovie: LiveData<List<FavData>> get() = _ListMovie
    fun getAllFavoriteMovie() {
        GlobalScope.launch {_ListMovie.postValue(db.getAllFavorite())
        }
    }
    fun deleteFavMovie(favMovie: FavData) {
        GlobalScope.launch {db.deleteFavorite(favMovie)
            _movie.postValue(favMovie)
        }

    }
}
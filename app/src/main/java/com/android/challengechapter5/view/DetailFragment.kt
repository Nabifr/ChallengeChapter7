package com.android.challengechapter5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.challengechapter5.databinding.FragmentDetailBinding
import com.android.challengechapter5.model.UpcomingMovieItem
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val getfilm = arguments?.getSerializable("BUNDEL") as UpcomingMovieItem
        Glide.with(view)
            .load("https://image.tmdb.org/t/p/w500${getfilm.posterPath}")
            .into(binding.ivFilmimagedetail)
        binding.tvNamaFilm.text = getfilm.title
        binding.tvRelease.text = "Release : ${getfilm.releaseDate}"
        binding.tvRating.text = "Rating : ${getfilm.popularity}"
        binding.tvSinopsis.text = """Overview:
            ${getfilm.overview}
        """.trimIndent()
    }
}
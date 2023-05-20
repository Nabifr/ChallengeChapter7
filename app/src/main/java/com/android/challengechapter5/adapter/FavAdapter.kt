package com.android.challengechapter5.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.challengechapter5.R
import com.android.challengechapter5.databinding.ItemFavBinding
import com.android.challengechapter5.room.FavData
import com.bumptech.glide.Glide

class FavAdapter(private val listMovie: List<FavData>) :
    RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemFavBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bmarkMovie(movie: FavData) {
                binding.apply {
                    binding.favfilm = movie
                    Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w400${movie.posterPath}")
                        .into(binding.imgFilm)
                    cardView.setOnClickListener{
                        val bundle = Bundle().apply {
                            putInt("ID", movie.id.toString().toInt())
                        }
                        it.findNavController().navigate(R.id.action_favFragment_to_detailFragment, bundle)
                    }
                }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bmarkMovie(listMovie[position])
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

}
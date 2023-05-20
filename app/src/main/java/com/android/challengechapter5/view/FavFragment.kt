package com.android.challengechapter5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.challengechapter5.adapter.FavAdapter
import com.android.challengechapter5.databinding.FragmentFavBinding
import com.android.challengechapter5.room.FavDatabase
import com.android.challengechapter5.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavFragment : Fragment() {

    private lateinit var viewModel : FavoriteViewModel
    private var _binding: FragmentFavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        getFavMov()
    }
    private fun getFavMov(){
        viewModel.getAllFavoriteMovie()
        viewModel.listMovie.observe(viewLifecycleOwner){
            if(it != null){
                binding.rvFav.layoutManager = LinearLayoutManager(requireContext())
                binding.rvFav.setHasFixedSize(false)
                binding.rvFav.adapter = FavAdapter(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
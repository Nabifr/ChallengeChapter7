package com.android.challengechapter5.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.challengechapter5.FilmAdapter
import com.android.challengechapter5.R
import com.android.challengechapter5.databinding.FragmentHomeBinding
import com.android.challengechapter5.viewmodel.UpcomingViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.hdHome)

        firebaseAuth = FirebaseAuth.getInstance()
        if(firebaseAuth.currentUser == null){
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        sharedPreferences = requireContext().getSharedPreferences("keyUser", Context.MODE_PRIVATE)

        var getUser = sharedPreferences.getString("user", "")
        binding.txtHeader.text = "Welcome, $getUser"

        binding.icProfile.setOnClickListener {
            var addUser = sharedPreferences.edit()
            addUser.putString("user", getUser)
            addUser.apply()
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        val viewModelMovie = ViewModelProvider(this).get(UpcomingViewModel::class.java)
        viewModelMovie.callApiUpcoming()
        viewModelMovie.liveDataMovie.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.rvHome.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.rvHome.adapter = FilmAdapter(it)
            }
        })

    }

    override fun onStart() {
        super.onStart()

    }
}
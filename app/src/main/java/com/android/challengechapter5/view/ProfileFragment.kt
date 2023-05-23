package com.android.challengechapter5.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.android.challengechapter5.R
import com.android.challengechapter5.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("keyUser", Context.MODE_PRIVATE)
        val getUser = sharedPreferences.getString("user", "")
        binding.etUname.setText(getUser)

        val getNama = sharedPreferences.getString("nama", "")
        binding.etNameLong.setText(getNama)

        val getTgl = sharedPreferences.getString("tgl", "")
        binding.etDateBirth.setText(getTgl)

        val getAlamat = sharedPreferences.getString("alamat", "")
        binding.etAddress.setText(getAlamat)

        binding.btnUpdate.setOnClickListener {
            val getUsername = binding.etUname.text.toString()
            val getNamaLengkap = binding.etNameLong.text.toString()
            val getTglLahir = binding.etDateBirth.text.toString()
            val getAlamat = binding.etAddress.text.toString()
            val addUser = sharedPreferences.edit()
            addUser.putString("user", getUsername)
            addUser.putString("nama", getNamaLengkap)
            addUser.putString("tgl", getTglLahir)
            addUser.putString("alamat", getAlamat)
            addUser.apply()

            Toast.makeText(context, "Update Berhasil", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }
        binding.btnCrashlytics.setOnClickListener {
            throw RuntimeException("Test Crash")
        }

        binding.btnLogout.setOnClickListener {
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            val addUser = sharedPreferences.edit()
            addUser.remove("nama")
            addUser.remove("tgl")
            addUser.remove("alamat")
            addUser.commit()
            Toast.makeText(context, "Keluar Berhasil", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
}
}
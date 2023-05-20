package com.android.challengechapter5.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.android.challengechapter5.R
import com.android.challengechapter5.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()
        binding.tvRegist.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }
        binding.btnLogin.setOnClickListener {
            var email = binding.EtEmail.text.toString()
            var passwd = binding.EtPwd.text.toString()

            if (email.isNotEmpty() && passwd.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, passwd).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    } else{
                        Toast.makeText(context,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context, "Kata Sandi Salah!", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
package com.example.ozuclubs.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        //auth = Firebase.auth

//        binding.buttonLogin.setOnClickListener { view: View ->
//            view.findNavController()
//                .navigate(R.id.action_mainFragment_to_ClubsFragment)
//        }

        binding.registerButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_registerFragment)
        }
        auth = FirebaseAuth.getInstance()
//        var currentUser = auth.currentUser
//        if(currentUser != null){
//
//        }
        binding.buttonLogin.setOnClickListener { view: View ->
            var email = binding.email.text.toString()
            var password = binding.passwordEditText.text.toString()


         if (TextUtils.isEmpty(email)) {
            binding.editTextTextEmailAddress.error = "Please enter your e-mail address"
            return@setOnClickListener
        } else if (TextUtils.isEmpty(password)) {
            binding.editTextPassword.error = "Please enter your password"
            return@setOnClickListener
        }
            signIn(email, password)

//            auth.signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener(requireActivity()){
//                    if (it.isSuccessful){
//                        view.findNavController()
//                            .navigate(R.id.action_mainFragment_to_ClubsFragment)
//                    }else{
//                        Toast.makeText(
//                            context, "Login is Unsuccessful.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }

        }

        return binding.root
    }

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            this.findNavController().navigate(R.id.action_mainFragment_to_ClubsFragment)
//        }
//    }


    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser
                    //updateUI(user)
                    this.findNavController().navigate(R.id.action_mainFragment_to_ClubsFragment)

                } else {
                    Toast.makeText(
                        context, "Authentication failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
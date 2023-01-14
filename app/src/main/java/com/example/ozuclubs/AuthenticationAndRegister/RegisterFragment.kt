package com.example.ozuclubs.AuthenticationAndRegister

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(
            inflater,
            R.layout.fragment_register,
            container,
            false
        )
        binding.backButton.setOnClickListener { view: View ->

            view.findNavController()
                .navigate(R.id.action_registerFragment_to_mainFragment)
        }

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        binding.regButton.setOnClickListener {
            var userMail = binding.editTextTextEmailAddress2.text.toString()
            var userPassword = binding.editTextTextPassword.text.toString()
            var userNameAndSurname =binding.textNameSurname.text.toString()

            if (TextUtils.isEmpty(userNameAndSurname)) {
            binding.textNameSurname.error = "Please enter your name and surname"
            return@setOnClickListener
          } else if (TextUtils.isEmpty(userMail)) {
                binding.editTextTextEmailAddress2.error = "Please enter your e-mail address"
                return@setOnClickListener
            } else if (TextUtils.isEmpty(userPassword)) {
                binding.editTextTextPassword.error = "Please enter your password"
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(
                binding.editTextTextEmailAddress2.text.toString(),
                binding.editTextTextPassword.text.toString()
            )
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "createUserWithEmail:success")
                        val currentUser = auth.currentUser
                        var currentUserDb =currentUser?.let {it1-> databaseReference?.child(it1.uid) }
                        currentUserDb?.child(("name&surname"))?.setValue(binding.textNameSurname.text.toString())
                        Toast.makeText(
                            context, "Register is Successful.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }else{
                        Toast.makeText(
                            context, "Register is Unsuccessful.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }


        }
        return binding.root
    }
}
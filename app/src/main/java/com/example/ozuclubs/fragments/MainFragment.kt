package com.example.ozuclubs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
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


        binding.buttonLogin.setOnClickListener { view: View ->

            view.findNavController()
                .navigate(R.id.action_mainFragment_to_ClubsFragment)
        }
        return binding.root
    }
}
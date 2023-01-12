package com.example.ozuclubs.MyList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentMylistBinding

class MyListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentMylistBinding>(inflater, R.layout.fragment_mylist, container, false)

        binding.backButton2
            .setOnClickListener { view: View ->

            view.findNavController()
                .navigate(R.id.action_myListFragment_to_eventsFragment)
        }
        return binding.root
    }
}
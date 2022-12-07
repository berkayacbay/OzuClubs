package com.example.ozuclubs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.ozuclubs.R

class EventsFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentEventsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_events, container, false)

        return binding.root
    }

}
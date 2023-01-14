package com.example.ozuclubs.EventsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ozuclubs.ClubsList.Club
import com.example.ozuclubs.ClubsList.ClubsFragment
import com.example.ozuclubs.MyNotesList.MyNotesListFragment
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {
    private lateinit var adapter1: EventAdapter

    private lateinit var eventsArrayList: List<Event>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentEventsBinding>(
            inflater,
            R.layout.fragment_events, container, false
        )

        eventsArrayList=loadEvents()
        adapter1 = EventAdapter(this,eventsArrayList)

        binding.recyclerView2.apply {
            layoutManager= LinearLayoutManager(context)
            hasFixedSize()
            this.adapter=adapter1


        }


        binding.bottomNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.nav_clubs -> {
                    view?.findNavController()?.navigate(R.id.action_eventsFragment_to_clubsFragment)

                }
                R.id.nav_notes -> {
                    view?.findNavController()?.navigate(R.id.action_eventsFragment_to_myListFragment)

                }
            }
        }


        return binding.root
    }

    fun loadEvents(): List<Event>{
        return listOf<Event>(
            Event(R.string.header_a,R.string.description_a,R.drawable.event_a),
            Event(R.string.header_b,R.string.description_b,R.drawable.event_b),
            Event(R.string.header_c,R.string.description_c,R.drawable.event_c),
            Event(R.string.header_d,R.string.description_d,R.drawable.event_d),
            Event(R.string.header_e,R.string.description_e,R.drawable.event_e),
            Event(R.string.header_f,R.string.description_f,R.drawable.event_f),


        )
    }


}
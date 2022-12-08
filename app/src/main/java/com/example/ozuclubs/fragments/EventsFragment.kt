package com.example.ozuclubs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.adapter.ClubAdapter
import com.example.ozuclubs.adapter.EventAdapter
import com.example.ozuclubs.data.Club
import com.example.ozuclubs.data.Event
import com.example.ozuclubs.data.MyList
import com.example.ozuclubs.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {
    private lateinit var adapter1: EventAdapter

    private lateinit var eventsArrayList: ArrayList<Event>

    lateinit var imageId: Array<Int>
    lateinit var eventHeader: Array<String>
    lateinit var eventBriefDesc: Array<String>

    lateinit var checkbox: Array<MyList>
    private lateinit var cb: CheckBox


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentEventsBinding>(
            inflater,
            R.layout.fragment_events, container, false
        )

        dataInitialize()
        adapter1 = EventAdapter(eventsArrayList)
        binding.recyclerView2.apply {
            layoutManager= LinearLayoutManager(context)
            hasFixedSize()
            this.adapter=adapter1


        }

        binding.buttonMylist.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_eventsFragment_to_myListFragment)
        }

        binding.buttonBack.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_eventsFragment_to_clubsFragment)
        }

        return binding.root
    }



    private fun dataInitialize() {
        eventsArrayList = arrayListOf<Event>()
        imageId = arrayOf(
            R.drawable.event_a,
            R.drawable.event_b,
            R.drawable.event_c,
            R.drawable.event_d,
            R.drawable.event_e,
            R.drawable.event_f,
        )
        eventHeader = arrayOf(
            getString(R.string.header_a),
            getString(R.string.header_b),
            getString(R.string.header_c),
            getString(R.string.header_d),
            getString(R.string.header_e),
            getString(R.string.header_f),

            )
        eventBriefDesc = arrayOf(
            getString(R.string.description_a),
            getString(R.string.description_b),
            getString(R.string.description_c),
            getString(R.string.description_d),
            getString(R.string.description_e),
            getString(R.string.description_f),

            )
        for (i in imageId.indices) {
            val event = Event(eventHeader[i], eventBriefDesc[i], imageId[i])
            eventsArrayList.add(event)
        }

    }


}
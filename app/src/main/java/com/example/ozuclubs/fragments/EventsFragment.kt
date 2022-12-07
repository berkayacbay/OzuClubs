package com.example.ozuclubs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.adapter.ClubAdapter
import com.example.ozuclubs.adapter.EventAdapter
import com.example.ozuclubs.data.Club
import com.example.ozuclubs.data.Event
import com.example.ozuclubs.databinding.FragmentEventsBinding

class EventsFragment: Fragment() {
    private  lateinit var adapter: EventAdapter
    private  lateinit var rv: RecyclerView
    private  lateinit var eventsArrayList:ArrayList<Event>

    lateinit var imageId: Array<Int>
    lateinit var eventName: Array<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentEventsBinding>(inflater,
            R.layout.fragment_events,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
         rv=view.findViewById(R.id.recycler_view2)
        rv.layoutManager=layoutManager
        rv.setHasFixedSize(true)
        adapter= EventAdapter(eventsArrayList)
        rv.adapter=adapter
    }

    private fun dataInitialize(){
         eventsArrayList= arrayListOf<Event>()
         imageId= arrayOf(
            R.drawable.event_a,
            R.drawable.event_b,
            R.drawable.event_c,
            R.drawable.event_d,
            R.drawable.event_e,
            R.drawable.event_f,
        )
        eventName= arrayOf(
            getString(R.string.description_a),
            getString(R.string.description_b),
            getString(R.string.description_c),
            getString(R.string.description_d),
            getString(R.string.description_e),
            getString(R.string.description_f),
        )
        for(i in imageId.indices){
            val event= Event(eventName[i],imageId[i])
            eventsArrayList.add(event)
        }

    }

}
package com.example.ozuclubs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.data.Club
import com.example.ozuclubs.data.Event

class EventAdapter(private val eventList:ArrayList<Event>):RecyclerView.Adapter<EventAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val eventImage: ImageView =itemView.findViewById(R.id.event_image)
        val eventName: TextView =itemView.findViewById(R.id.event_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_event,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =eventList[position]
        holder.eventImage.setImageResource(currentItem.eventImage)
        holder.eventName.text=currentItem.eventName

    }

    override fun getItemCount(): Int {
        return eventList.size
    }


}
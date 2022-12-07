package com.example.ozuclubs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.data.Event

class EventAdapter(private val eventList:ArrayList<Event>):RecyclerView.Adapter<EventAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val eventImage: ImageView =itemView.findViewById(R.id.event_image)
        val eventHeader: TextView =itemView.findViewById(R.id.event_header)
        val eventBriefDesc: TextView =itemView.findViewById(R.id.text_briefdesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_event,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =eventList[position]
        holder.eventImage.setImageResource(currentItem.eventImage)
        holder.eventHeader.text=currentItem.eventHeader
        holder.eventBriefDesc.text=currentItem.eventBriefDesc

    }

    override fun getItemCount(): Int {
        return eventList.size
    }


}
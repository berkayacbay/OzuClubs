package com.example.ozuclubs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.data.Club

class ClubAdapter(private val clubsList:ArrayList<Club>):RecyclerView.Adapter<ClubAdapter.MyViewHolder>() {

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val clubImage: ImageView =itemView.findViewById(R.id.club_image)
    val clubName: TextView =itemView.findViewById(R.id.club_name)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_club,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem =clubsList[position]
        holder.clubImage.setImageResource(currentItem.clubImage)
        holder.clubName.text=currentItem.clubName

    }

    override fun getItemCount(): Int {
       return clubsList.size
    }


}
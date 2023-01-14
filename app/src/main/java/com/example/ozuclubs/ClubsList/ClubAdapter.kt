package com.example.ozuclubs.ClubsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R

class ClubAdapter(
    private val context: ClubsFragment,
    private val clubsList: List<Club>) :
    RecyclerView.Adapter<ClubAdapter.MyViewHolder>() {

    class MyViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clubName: TextView = itemView.findViewById(R.id.club_name)
        val clubImage: ImageView = itemView.findViewById(R.id.club_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_club, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = clubsList[position]
        holder.clubName.text= context.resources.getString(currentItem.clubName)
        holder.clubImage.setImageResource(currentItem.clubImage)
    }

    override fun getItemCount(): Int {
        return clubsList.size
    }


}
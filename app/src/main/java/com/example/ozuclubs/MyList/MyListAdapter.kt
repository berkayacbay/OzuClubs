package com.example.ozuclubs.MyList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.MyList.Database.Note
import com.example.ozuclubs.R
import com.example.ozuclubs.data.MyList

class MyListAdapter: RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {
     var data =  listOf<Note>()
          set(value) {
               field = value
               notifyDataSetChanged()
          }
     class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

          val noteId: TextView = itemView.findViewById(R.id.text_noteId)
          val noteTitle: TextView = itemView.findViewById(R.id.textTitle)
          val noteDesc: TextView = itemView.findViewById(R.id.text_desc)
          val noteTime: TextView =itemView.findViewById(R.id.text_time)
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
          val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_mylist, parent,false)
          return MyListAdapter.MyViewHolder(layout)
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          val currentItem = data[position]
          holder.noteId.text = currentItem.id.toString()
          holder.noteTitle.text = currentItem.note_title
          holder.noteDesc.text = currentItem.note_description
          holder.noteTime.text = currentItem.note_time

     }

     override fun getItemCount(): Int {
          return data.size
     }


}
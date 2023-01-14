package com.example.ozuclubs.MyNotesList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.MyNotesList.Database.Note
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.ListMylistBinding

class MyListAdapter: ListAdapter<Note,MyListAdapter.MyViewHolder>(MyListDiffCallback()) {
//     var data =  listOf<Note>()
//          set(value) {
//               field = value
//               notifyDataSetChanged()
//          }

     class MyViewHolder(binding: ListMylistBinding): RecyclerView.ViewHolder(binding.root){

//          val noteId: TextView = itemView.findViewById(R.id.text_noteId)
//          val noteTitle: TextView = itemView.findViewById(R.id.textTitle)
//          val noteDesc: TextView = itemView.findViewById(R.id.text_desc)
//          val noteTime: TextView =itemView.findViewById(R.id.text_time)
//          val imageNote: ImageView =itemView.findViewById(R.id.image_note)

          val noteId: TextView = binding.textNoteId
          val noteTitle: TextView = binding.textTitle
          val noteDesc: TextView = binding.textDesc
          val noteTime: TextView = binding.textTime
          val imageNote: ImageView = binding.imageNote

          companion object {
               fun from(parent: ViewGroup): MyViewHolder {
                   val layoutInflater = LayoutInflater.from(parent.context)
//                    val view = layoutInflater
//                         .inflate(R.layout.list_mylist, parent, false)
                    val binding = ListMylistBinding.inflate(layoutInflater,parent,false)
                    return MyViewHolder(binding)
               }
          }

          fun bind(note: Note){
               noteId.text = note.id.toString()
               noteTitle.text =note.note_title
               noteDesc.text = note.note_description
               noteTime.text = note.note_time

               imageNote.setImageResource(when (note.id %6 ){
                    0 -> R.drawable.note1
                    1 -> R.drawable.note2
                    2 -> R.drawable.note3
                    3 -> R.drawable.note4
                    4 -> R.drawable.note5
                    5 -> R.drawable.note6
                    else-> R.drawable.note1
               })


          }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//          val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_mylist, parent,false)
//          return MyListAdapter.MyViewHolder(layout)
          return MyViewHolder.from(parent)
     }


     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          val currentItem = getItem(position)
          holder.bind(currentItem)
//          holder.noteId.text = currentItem.id.toString()
//          holder.noteTitle.text = currentItem.note_title
//          holder.noteDesc.text = currentItem.note_description
//          holder.noteTime.text = currentItem.note_time

     }




}
class MyListDiffCallback : DiffUtil.ItemCallback<Note>(){
     override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
          return oldItem.id == newItem.id
     }

     override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
          return oldItem == newItem
     }

}
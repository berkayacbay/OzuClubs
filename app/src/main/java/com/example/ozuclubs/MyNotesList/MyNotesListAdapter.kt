package com.example.ozuclubs.MyNotesList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.Note
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.ListMylistBinding

class MyListAdapter : ListAdapter<Note, MyListAdapter.MyViewHolder>(MyListDiffCallback()) {

    class MyViewHolder(val binding: ListMylistBinding) : RecyclerView.ViewHolder(binding.root) {


        val noteId: TextView = binding.textNoteId

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListMylistBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

        fun bind(note: Note) {
            noteId.text = note.id.toString()
            binding.note = note

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)

    }

}

class MyListDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

}
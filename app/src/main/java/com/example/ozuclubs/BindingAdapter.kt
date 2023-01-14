package com.example.ozuclubs.MyNotesList

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.ozuclubs.Note
import com.example.ozuclubs.R



@BindingAdapter("imageNote")
    fun ImageView.setNoteImage(item: Note){
        setImageResource(when (item.id %6 ){
            0 -> R.drawable.note1
            1 -> R.drawable.note2
            2 -> R.drawable.note3
            3 -> R.drawable.note4
            4 -> R.drawable.note5
            5 -> R.drawable.note6
            else-> R.drawable.note1
        })
    }

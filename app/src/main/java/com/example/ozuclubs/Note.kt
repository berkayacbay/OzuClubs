package com.example.ozuclubs

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id :Int,
    val note_title: String,
    val note_description : String,
    val note_time :String
)

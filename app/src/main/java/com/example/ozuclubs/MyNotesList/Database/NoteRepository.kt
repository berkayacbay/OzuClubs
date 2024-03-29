package com.example.ozuclubs.MyNotesList.Database

import androidx.lifecycle.LiveData
import com.example.ozuclubs.Note

class NoteRepository(private val noteDao: NoteDao) {

    val readAllData: LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note) {
        noteDao.insert(note)
    }

}
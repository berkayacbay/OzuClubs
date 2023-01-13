package com.example.ozuclubs.MyList.Database

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

      val readAllData : LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note){
        noteDao.insert(note)
    }

}
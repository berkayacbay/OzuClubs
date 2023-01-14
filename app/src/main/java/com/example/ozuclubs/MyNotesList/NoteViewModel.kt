package com.example.ozuclubs.MyNotesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ozuclubs.Note
import com.example.ozuclubs.MyNotesList.Database.NoteDatabase
import com.example.ozuclubs.MyNotesList.Database.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository= NoteRepository(noteDao)
        readAllData = repository.readAllData
    }
    fun addNote(note: Note){
        viewModelScope.launch (Dispatchers.IO){
            repository.addNote(note)
        }
    }

}

/*class PlantListViewModelFactory(private val dataSource: NoteDao, private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/
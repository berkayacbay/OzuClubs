package com.example.ozuclubs.MyNotesList

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ozuclubs.Note
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentAddNoteBinding

class addNoteFragment : Fragment() {
    private lateinit var myNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAddNoteBinding>(
            inflater,
            R.layout.fragment_add_note,
            container,
            false
        )


        myNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)



        binding.buttonAddnote.setOnClickListener {
            val title = binding.edittextTitle.text.toString()
            val desc = binding.edittextDesc.text.toString()
            val time = binding.editextTime.text.toString()
            insertDatatoDatabase(title, desc, time)

        }

        return binding.root
    }

    private fun insertDatatoDatabase(title: String, desc: String, time: String) {
        if (inputCheck(title, desc, time)) {
            val note = Note(0, title, desc, time)
            myNoteViewModel.addNote(note)
            Toast.makeText(requireContext(), "Successfully added.", Toast.LENGTH_LONG).show()
            findNavController().navigate((R.id.action_addNoteFragment_to_myListFragment))
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun inputCheck(title: String, desc: String, time: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(desc) && TextUtils.isEmpty(time))
    }


}
package com.example.ozuclubs.MyList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentMylistBinding

class MyListFragment : Fragment() {

private lateinit var  mNoteViewModel: NoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentMylistBinding>(inflater, R.layout.fragment_mylist, container, false)
        val myAdapter =MyListAdapter()

      binding.rvMynotes.apply {
            layoutManager= LinearLayoutManager(context)
            hasFixedSize()
            this.adapter=myAdapter
        }
        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mNoteViewModel.readAllData.observe(viewLifecycleOwner, Observer { it?.let{
            myAdapter.data =it
        }
        })
        binding.setLifecycleOwner (this)

        binding.floatingButtonAdd.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_myListFragment_to_addNoteFragment)

        }

        return binding.root
    }
}
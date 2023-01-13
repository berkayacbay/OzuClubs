package com.example.ozuclubs.Clubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ozuclubs.R
import com.example.ozuclubs.data.Club
import com.example.ozuclubs.databinding.FragmentClubsBinding

class ClubsFragment : Fragment() {



    private lateinit var clubsArrayList: ArrayList<Club>
    private lateinit var adapter1: ClubAdapter

    lateinit var imageId: Array<Int>
    lateinit var clubName: Array<String>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentClubsBinding>(inflater, R.layout.fragment_clubs, container, false)

        dataInitialize()
        adapter1 = ClubAdapter(clubsArrayList)
        binding.recyclerView1.apply {
            layoutManager= LinearLayoutManager(context)
            hasFixedSize()
            this.adapter=adapter1


        }
        binding.buttonEvent.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_clubsFragment_to_eventsFragment)
        }

//        binding.buttonBack2.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_ClubsFragment_to_mainFragment)
//        }
        return binding.root
    }



    private fun dataInitialize() {
        clubsArrayList = arrayListOf<Club>()
        imageId = arrayOf(
            R.drawable.image_a,
            R.drawable.image_b,
            R.drawable.image_c,
            R.drawable.image_d,
            R.drawable.image_e,
            R.drawable.image_f,
            R.drawable.image_g,
            R.drawable.image_h,
            R.drawable.image_i,
            R.drawable.image_j,
            R.drawable.image_k,
        )
        clubName = arrayOf(
            getString(R.string.club_a),
            getString(R.string.club_b),
            getString(R.string.club_c),
            getString(R.string.club_d),
            getString(R.string.club_e),
            getString(R.string.club_f),
            getString(R.string.club_g),
            getString(R.string.club_h),
            getString(R.string.club_i),
            getString(R.string.club_j),
            getString(R.string.club_k),
        )
        for (i in imageId.indices) {
            val club = Club(clubName[i], imageId[i])
            clubsArrayList.add(club)
        }

    }


}
package com.example.ozuclubs.ClubsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ozuclubs.R
import com.example.ozuclubs.databinding.FragmentClubsBinding

class ClubsFragment : Fragment() {

    private lateinit var clubsArrayList: List<Club>
    private lateinit var adapter1: ClubAdapter

    lateinit var imageId: Array<Int>
    lateinit var clubName: Array<String>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentClubsBinding>(inflater, R.layout.fragment_clubs, container, false)

        clubsArrayList= loadClubs()
        adapter1 = ClubAdapter(this,clubsArrayList)
        binding.recyclerView1.apply {
            layoutManager= LinearLayoutManager(context)
            hasFixedSize()
            this.adapter=adapter1


        }


        binding.bottomNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.nav_events -> {
                    view?.findNavController()?.navigate(R.id.action_clubsFragment_to_eventsFragment)

                }
                R.id.nav_notes -> {
                    view?.findNavController()?.navigate(R.id.action_ClubsFragment_to_myListFragment)

                }
            }
        }


        return binding.root
    }

    fun loadClubs(): List<Club>{
        return listOf<Club>(
            Club(R.string.club_a,R.drawable.image_a),
            Club(R.string.club_b,R.drawable.image_b),
            Club(R.string.club_c,R.drawable.image_c),
            Club(R.string.club_d,R.drawable.image_d),
            Club(R.string.club_e,R.drawable.image_e),
            Club(R.string.club_f,R.drawable.image_f),
            Club(R.string.club_g,R.drawable.image_g),
            Club(R.string.club_h,R.drawable.image_h),
            Club(R.string.club_i,R.drawable.image_i),
            Club(R.string.club_j,R.drawable.image_j),
            Club(R.string.club_k,R.drawable.image_k)



                )
    }



}
package com.example.dadm_u2p2_cine.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dadm_u2p2_cine.fragment.ComprasFragment

class TabFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            1 -> ComprasFragment()
            2 -> ComprasFragment()
        }
        return ComprasFragment()
    }
}
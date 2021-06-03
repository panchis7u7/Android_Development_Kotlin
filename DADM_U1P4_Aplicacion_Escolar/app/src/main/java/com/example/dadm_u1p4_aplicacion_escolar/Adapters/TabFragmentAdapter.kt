package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dadm_u1p4_aplicacion_escolar.Fragments.CurrentSelectionFragment
import com.example.dadm_u1p4_aplicacion_escolar.Fragments.SubjectSelectionFragment

class TabFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when(position){
            1 -> return SubjectSelectionFragment()
        }
        return CurrentSelectionFragment()
    }

}
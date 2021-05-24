package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.dadm_u2p2_cine.adapter.TabFragmentAdapter
import com.example.dadm_u2p2_cine.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayout

class ProfileFragment: Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.viewPagerUser.adapter = TabFragmentAdapter(parentFragmentManager, lifecycle)
        binding.tabLayoutUser.addTab(binding.tabLayoutUser.newTab().setText("Datos"))
        binding.tabLayoutUser.addTab(binding.tabLayoutUser.newTab().setText("Compras"))
        binding.tabLayoutUser.addTab(binding.tabLayoutUser.newTab().setText("Favoritos"))

        binding.tabLayoutUser.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPagerUser.setCurrentItem(tab!!.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.viewPagerUser.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.tabLayoutUser.selectTab(binding.tabLayoutUser.getTabAt(position))
            }
        })

       return binding.root
    }
}
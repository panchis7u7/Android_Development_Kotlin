package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.TabFragmentAdapter
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivitySeleccionBinding
import com.google.android.material.tabs.TabLayout

class SeleccionActivity : AppCompatActivity() {
    private var _binding: ActivitySeleccionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySeleccionBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_seleccion)
        setContentView(binding.root)

        binding.viewPagerSelection.adapter = TabFragmentAdapter(supportFragmentManager, lifecycle)
        binding.tabLayoutSelection.addTab(binding.tabLayoutSelection.newTab().setText("Seleccion Actual"))
        binding.tabLayoutSelection.addTab(binding.tabLayoutSelection.newTab().setText("Materias"))

        binding.tabLayoutSelection.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPagerSelection.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.viewPagerSelection.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                println(position)
                binding.tabLayoutSelection.selectTab(binding.tabLayoutSelection.getTabAt(position))
                super.onPageSelected(position)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
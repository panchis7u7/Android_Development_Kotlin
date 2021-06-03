package com.example.dadm_u1p4_aplicacion_escolar.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dadm_u1p4_aplicacion_escolar.R
import com.example.dadm_u1p4_aplicacion_escolar.databinding.FragmentCurrentSelectionBinding

class CurrentSelectionFragment: Fragment(R.layout.fragment_current_selection) {
    private var _binding: FragmentCurrentSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCurrentSelectionBinding.inflate(layoutInflater)



        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
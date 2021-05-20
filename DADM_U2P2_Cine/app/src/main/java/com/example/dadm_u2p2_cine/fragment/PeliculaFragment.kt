package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.databinding.FragmentPeliculaBinding

class PeliculaFragment: Fragment(R.layout.fragment_pelicula) {
    private var _binding: FragmentPeliculaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeliculaBinding.inflate(layoutInflater)



        return binding.root
    }
}
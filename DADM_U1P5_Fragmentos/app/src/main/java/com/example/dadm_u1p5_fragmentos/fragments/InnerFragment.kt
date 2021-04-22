package com.example.dadm_u1p5_fragmentos.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dadm_u1p5_fragmentos.databinding.FragmentInnerBinding

class InnerFragment: Fragment() {
    private lateinit var binding: FragmentInnerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentInnerBinding.inflate(layoutInflater)


        return binding.root
    }
}
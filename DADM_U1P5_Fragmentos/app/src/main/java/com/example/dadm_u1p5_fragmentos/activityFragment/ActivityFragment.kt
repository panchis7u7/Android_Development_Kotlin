package com.example.dadm_u1p5_fragmentos.activityFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dadm_u1p5_fragmentos.R
import com.example.dadm_u1p5_fragmentos.databinding.FragmentActivityBinding

class ActivityFragment : Fragment() {
    private lateinit var binding: FragmentActivityBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentActivityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
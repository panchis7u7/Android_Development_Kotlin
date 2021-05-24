package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.databinding.FragmentCompraStatusLayoutBinding

class CompraStatusFragment: Fragment(R.layout.fragment_compra_status_layout) {
    private var _binding: FragmentCompraStatusLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompraStatusLayoutBinding.inflate(layoutInflater)

        //Thread.sleep(4000)
        findNavController().navigate(R.id.action_compraStatusFragment_to_homeFragment)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
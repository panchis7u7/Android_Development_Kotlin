package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.adapter.RecyclerComprasAdapter
import com.example.dadm_u2p2_cine.databinding.FragmentComprasBinding
import com.example.dadm_u2p2_cine.model.DBManager

class ComprasFragment: Fragment(R.layout.fragment_compras) {
    private var _binding: FragmentComprasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComprasBinding.inflate(layoutInflater)

        val db = DBManager(requireContext(), "cine", null, 1)

        binding.recyclerCompras.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerCompras.adapter = RecyclerComprasAdapter(requireContext(), db.getCompras())

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
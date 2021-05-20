package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.adapter.RecyclerSeatAdapter
import com.example.dadm_u2p2_cine.databinding.FragmentSeatSelectionBinding
import com.example.dadm_u2p2_cine.model.SeatRow

class SelectionFragment: Fragment(R.layout.fragment_seat_selection) {
    private var _binding: FragmentSeatSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeatSelectionBinding.inflate(layoutInflater)

        binding.recyclerViewSelection.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerViewSelection.adapter = RecyclerSeatAdapter(requireContext(), populate())

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun populate(): MutableList<SeatRow>{
        var seats: MutableList<SeatRow> = mutableListOf()

        var row1: MutableList<AppCompatButton> = mutableListOf()
        row1.add(AppCompatButton(requireContext()))
        row1.add(AppCompatButton(requireContext()))
        row1.add(AppCompatButton(requireContext()))
        row1.add(AppCompatButton(requireContext()))
        row1.add(AppCompatButton(requireContext()))

        var row2: MutableList<AppCompatButton> = mutableListOf()
        row2.add(AppCompatButton(requireContext()))
        row2.add(AppCompatButton(requireContext()))
        row2.add(AppCompatButton(requireContext()))
        row2.add(AppCompatButton(requireContext()))
        row2.add(AppCompatButton(requireContext()))
        row2.add(AppCompatButton(requireContext()))

        var row3: MutableList<AppCompatButton> = mutableListOf()
        row3.add(AppCompatButton(requireContext()))
        row3.add(AppCompatButton(requireContext()))
        row3.add(AppCompatButton(requireContext()))
        row3.add(AppCompatButton(requireContext()))
        row3.add(AppCompatButton(requireContext()))
        row3.add(AppCompatButton(requireContext()))
        row3.add(AppCompatButton(requireContext()))

        var row4: MutableList<AppCompatButton> = mutableListOf()
        row4.add(AppCompatButton(requireContext()))
        row4.add(AppCompatButton(requireContext()))
        row4.add(AppCompatButton(requireContext()))
        row4.add(AppCompatButton(requireContext()))
        row4.add(AppCompatButton(requireContext()))
        row4.add(AppCompatButton(requireContext()))

        var row5: MutableList<AppCompatButton> = mutableListOf()
        row5.add(AppCompatButton(requireContext()))
        row5.add(AppCompatButton(requireContext()))
        row5.add(AppCompatButton(requireContext()))
        row5.add(AppCompatButton(requireContext()))
        row5.add(AppCompatButton(requireContext()))
        row5.add(AppCompatButton(requireContext()))
        row5.add(AppCompatButton(requireContext()))

        var row6: MutableList<AppCompatButton> = mutableListOf()
        row6.add(AppCompatButton(requireContext()))
        row6.add(AppCompatButton(requireContext()))
        row6.add(AppCompatButton(requireContext()))
        row6.add(AppCompatButton(requireContext()))
        row6.add(AppCompatButton(requireContext()))
        row6.add(AppCompatButton(requireContext()))

        seats.add(SeatRow(1, row1))
        seats.add(SeatRow(2, row2))
        seats.add(SeatRow(3, row3))
        seats.add(SeatRow(4, row4))
        seats.add(SeatRow(5, row5))
        seats.add(SeatRow(6, row6))

        return seats
    }
}
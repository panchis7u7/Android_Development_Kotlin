package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.adapter.RecyclerCategoriasAdapter
import com.example.dadm_u2p2_cine.adapter.RecyclerSeatAdapter
import com.example.dadm_u2p2_cine.databinding.FragmentSeatSelectionBinding
import com.example.dadm_u2p2_cine.model.Categoria
import com.example.dadm_u2p2_cine.model.SeatRow

class SelectionFragment: Fragment(R.layout.fragment_seat_selection) {
    private var _binding: FragmentSeatSelectionBinding? = null
    private val binding get() = _binding!!
    private var boletos: Int = 0
    private var price: Int = 0
    private var date: String? = ""
    private var time: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeatSelectionBinding.inflate(layoutInflater)

        binding.recyclerViewSelection.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerViewSelection.adapter = object : RecyclerSeatAdapter(requireContext(), populate()) {
            override fun selectedRow(row: Int, seat: Int, seatStates: Array<IntArray>) {
                //Toast.makeText(requireContext(), "Asiento: ${row}${seat}.", Toast.LENGTH_LONG).show()
                if(seatStates[row-1][seat] == 0) {
                    boletos++
                    binding.textViewCantidad.text = "${boletos} asientos"
                    price = boletos * 100
                    binding.textViewPrecio.text = "$${price}.00"
                } else {
                    boletos--
                    binding.textViewCantidad.text = "${boletos} asientos"
                    price = boletos * 100
                    binding.textViewPrecio.text = "$${price}.00"
                }
                if(boletos > 0 && date != "" && time != "")
                    binding.buttonComprar.isEnabled = true
            }
        }

        binding.recyclerViewDates.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.recyclerViewDates.adapter = object : RecyclerCategoriasAdapter(requireContext(), populateDates()){
            override fun onButtonSelected(content: String) {
                date = content
                if(boletos > 0 && date != "" && time != "")
                    binding.buttonComprar.isEnabled = true
            }

        }

        binding.recyclerViewTimes.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.recyclerViewTimes.adapter = object : RecyclerCategoriasAdapter(requireContext(), populateTimes()){
            override fun onButtonSelected(content: String) {
                time = content
                if(boletos > 0 && date != "" && time != "")
                    binding.buttonComprar.isEnabled = true
            }

        }

        binding.buttonComprar.setOnClickListener {
            Toast.makeText(requireContext(), """
                Boletos: ${boletos},
                Horario: ${date},
                Hora: ${time},
                Precio: ${price}
            """.trimIndent(), Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun populateDates(): MutableList<String> {
        var dates: MutableList<String> = mutableListOf()

        dates.add("11 Marzo")
        dates.add("12 Marzo")
        dates.add("13 Marzo")
        dates.add("14 Marzo")

        return dates
    }

    private fun populateTimes(): MutableList<String> {
        var times: MutableList<String> = mutableListOf()

        times.add("12:30")
        times.add("15:00")
        times.add("17:30")
        times.add("20:00")

        return times
    }

    private fun populate(): MutableList<SeatRow>{
        var seats: MutableList<SeatRow> = mutableListOf()

        var row1: MutableList<Int> = mutableListOf()
        row1.add(1)
        row1.add(2)
        row1.add(3)
        row1.add(4)
        row1.add(5)

        var row2: MutableList<Int> = mutableListOf()
        row2.add(1)
        row2.add(2)
        row2.add(3)
        row2.add(4)
        row2.add(5)
        row2.add(6)

        var row3: MutableList<Int> = mutableListOf()
        row3.add(1)
        row3.add(2)
        row3.add(3)
        row3.add(4)
        row3.add(5)
        row3.add(6)
        row3.add(7)

        var row4: MutableList<Int> = mutableListOf()
        row4.add(1)
        row4.add(2)
        row4.add(3)
        row4.add(4)
        row4.add(5)
        row4.add(6)

        var row5: MutableList<Int> = mutableListOf()
        row5.add(1)
        row5.add(2)
        row5.add(3)
        row5.add(4)
        row5.add(5)
        row5.add(6)
        row5.add(7)

        var row6: MutableList<Int> = mutableListOf()
        row6.add(1)
        row6.add(2)
        row6.add(3)
        row6.add(4)
        row6.add(5)
        row6.add(6)

        seats.add(SeatRow(1, row1))
        seats.add(SeatRow(2, row2))
        seats.add(SeatRow(3, row3))
        seats.add(SeatRow(4, row4))
        seats.add(SeatRow(5, row5))
        seats.add(SeatRow(6, row6))

        return seats
    }
}
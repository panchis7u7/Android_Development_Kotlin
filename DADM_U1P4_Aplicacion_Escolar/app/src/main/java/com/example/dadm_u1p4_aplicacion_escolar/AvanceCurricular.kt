package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceCurricular
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityAvanceCurricularBinding

class AvanceCurricular : AppCompatActivity() {
    private lateinit var binding: ActivityAvanceCurricularBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gridItemAdapter: RecyclerAdapterAvanceCurricular
    private var models: MutableList<Materia> = mutableListOf<Materia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvanceCurricularBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_avance_curricular)
        setContentView(binding.root)

        gridLayoutManager = GridLayoutManager(applicationContext, 6, LinearLayoutManager.VERTICAL, false)
        binding.recyclerAvance.layoutManager = gridLayoutManager
        binding.recyclerAvance.setHasFixedSize(true)
        models = populateList()
        gridItemAdapter = RecyclerAdapterAvanceCurricular(applicationContext, models)
        binding.recyclerAvance.adapter = gridItemAdapter
    }

    private fun populateList(): MutableList<Materia>{
        var items: MutableList<Materia> = mutableListOf<Materia>()

        items.add(Materia("B1T1", "Calculo Diferencial", "73", "O1"))
        items.add(Materia("B1T2", "Fundamentos de Programacion", "93", "O1"))
        items.add(Materia("B1T3", "Matematicas Discretas", "70", "R1"))
        items.add(Materia("B1T4", "Introduccion a las Tics", "83", "O1"))
        items.add(Materia("B1T5", "Taller de Etica", "73", "O1"))
        items.add(Materia("B1T6", "Fundamentos de Investigacion", "86", "R1"))

        return items
    }
}
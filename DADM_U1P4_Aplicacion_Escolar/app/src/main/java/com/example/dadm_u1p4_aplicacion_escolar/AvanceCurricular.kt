package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceMaterias
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceSemestres
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityAvanceCurricularBinding

class AvanceCurricular : AppCompatActivity() {
    private lateinit var binding: ActivityAvanceCurricularBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gridItemAdapter: RecyclerAdapterAvanceMaterias
    private var models: MutableList<Materia> = mutableListOf<Materia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvanceCurricularBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_avance_curricular)
        setContentView(binding.root)

        semestresRecycler(populateList())
    }

    private fun populateList(): MutableList<Semestre>{

        var materias1: MutableList<Materia> = mutableListOf<Materia>()
        materias1.add(Materia("B1T1", "Calculo Diferencial", "73", "O1"))
        materias1.add(Materia("B1T2", "Fundamentos de Programacion", "93", "O1"))
        materias1.add(Materia("B1T3", "Matematicas Discretas", "70", "R1"))
        materias1.add(Materia("B1T4", "Introduccion a las Tics", "83", "O1"))
        materias1.add(Materia("B1T5", "Taller de Etica", "73", "O1"))
        materias1.add(Materia("B1T6", "Fundamentos de Investigacion", "86", "R1"))

        var materias2: MutableList<Materia> = mutableListOf<Materia>()
        materias2.add(Materia("B2T1", "Calculo Integral", "90", "O1"))
        materias2.add(Materia("B2T2", "Programacion Orientada a Objetos", "100", "O1"))
        materias2.add(Materia("B2T3", "Matematicas Discretas II", "95", "O1"))
        materias2.add(Materia("B2T4", "Algebra Lineal", "95", "O1"))
        materias2.add(Materia("B2T5", "Probabilidad y Estadistica", "87", "R1"))
        materias2.add(Materia("B2T6", "Contabilidad y Costos", "89", "O1"))

        var semestres: MutableList<Semestre> = mutableListOf<Semestre>()
        semestres.add(Semestre("Semestre 1", materias1))
        semestres.add(Semestre("Semestre 2", materias2))

        return semestres
    }

    private fun semestresRecycler(semestres: MutableList<Semestre>){
        binding.recyclerAvanceCurricular.layoutManager = LinearLayoutManager(this@AvanceCurricular,
        RecyclerView.VERTICAL, false)
        var recycleAdapterSemestre: RecyclerAdapterAvanceSemestres = RecyclerAdapterAvanceSemestres(
            this@AvanceCurricular, semestres)
        binding.recyclerAvanceCurricular.adapter= recycleAdapterSemestre

    }
}
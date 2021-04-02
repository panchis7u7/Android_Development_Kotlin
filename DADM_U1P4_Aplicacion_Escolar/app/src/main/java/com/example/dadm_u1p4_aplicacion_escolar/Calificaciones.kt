package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceMaterias
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteMateria
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityCalificacionesBinding

class Calificaciones : AppCompatActivity() {

    private lateinit var binding: ActivityCalificacionesBinding
    private var models: MutableList<Materia> = mutableListOf<Materia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calificaciones)
        binding = ActivityCalificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter: RecyclerAdapterCalificaciones = RecyclerAdapterCalificaciones(this,
        populateList())
        binding.recyclerCalificaciones.layoutManager = LinearLayoutManager(this,
        RecyclerView.VERTICAL, false)
        binding.recyclerCalificaciones.adapter = adapter

    }

    private fun populateList(): MutableList<ReporteMateria>{
        var reporte: MutableList<ReporteMateria> = mutableListOf()

        reporte.add(ReporteMateria(Materia("B1T1", "Calculo Diferencial", "100",
        "O1", "5"), "100", "Regularizacion Ordinaria Primera Vez",
        "Curso Aprobado"))

        reporte.add(ReporteMateria(Materia("B1T2", "Introduccion a las Tics", "100",
            "O1", "4"), "100", "Regularizacion Ordinaria Primera Vez",
            "Curso Aprobado"))

        reporte.add(ReporteMateria(Materia("B1T2", "Matematicas aplicadas a Telecomunicaciones", "100",
            "O1", "4"), "100", "Regularizacion Ordinaria Primera Vez",
            "Curso Aprobado"))
        return reporte
    }
}
package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificacionesItems
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteMateria
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteSemestral
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityCalificacionesBinding

class Calificaciones : AppCompatActivity() {

    private lateinit var binding: ActivityCalificacionesBinding
    private var models: MutableList<Materia> = mutableListOf<Materia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calificaciones)
        binding = ActivityCalificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calificacionesRecycler(populateList())
    }

    private fun populateList(): MutableList<ReporteSemestral>{
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

        var reporte2 : MutableList<ReporteMateria> = mutableListOf()

        reporte2.add(ReporteMateria(Materia("B1T1", "Calculo Diferencial", "100",
            "O1", "5"), "100", "Regularizacion Ordinaria Primera Vez",
            "Curso Aprobado"))

        reporte2.add(ReporteMateria(Materia("B1T2", "Introduccion a las Tics", "100",
            "O1", "4"), "100", "Regularizacion Ordinaria Primera Vez",
            "Curso Aprobado"))

        reporte2.add(ReporteMateria(Materia("B1T2", "Matematicas aplicadas a Telecomunicaciones", "100",
            "O1", "4"), "100", "Regularizacion Ordinaria Primera Vez",
            "Curso Aprobado"))

        var reporteSemestral: MutableList<ReporteSemestral> = mutableListOf()
        reporteSemestral.add(ReporteSemestral("Agosto - Diciembre", reporte))
        reporteSemestral.add(ReporteSemestral("Enero - Junio", reporte2))


        return reporteSemestral
    }

    private fun calificacionesRecycler(registros: MutableList<ReporteSemestral>){
        binding.recyclerCalificaciones.layoutManager = LinearLayoutManager(this@Calificaciones,
        RecyclerView.VERTICAL, false)

        var recycleAdapterCalificaciones: RecyclerAdapterCalificaciones = RecyclerAdapterCalificaciones(
            this@Calificaciones, registros)

        binding.recyclerCalificaciones.adapter = recycleAdapterCalificaciones
    }
}
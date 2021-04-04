package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteSemestral
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityCalificacionesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap

class Calificaciones : AppCompatActivity() {

    private lateinit var binding: ActivityCalificacionesBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calificaciones)
        binding = ActivityCalificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        var kardex: MutableList<ReporteSemestral> = mutableListOf()

        db = FirebaseFirestore.getInstance()
        db.collection("materias").document(auth.currentUser.uid).get()
            .addOnSuccessListener { document ->
                if(document != null){

                    var semestres : HashMap<String, Object> = (document.get("semestre") as HashMap<String, Object>)
                    var lista: List<Object>
                    var calificaciones: MutableList<Materia>

                    for(i in 1 .. 2){

                        lista = (semestres.get(i.toString()) as List<Object>)
                        calificaciones = mutableListOf()
                        //Log.d("Prueba", "Semestres : ${semestres.get(i.toString())}")

                        lista.map {
                            var mat = (it as HashMap<String, Any>)

                            calificaciones.add(Materia(
                                (mat.get("clave") as String),
                                (mat.get("materia") as String),
                                (mat.get("creditos") as String),
                                (mat.get("calificacion") as String),
                                (mat.get("evaluacion") as String),
                                (mat.get("observaciones") as String),
                                (mat.get("regularizacion") as String)
                            ))
                        }
                        kardex.add(ReporteSemestral("Agosto - Junio 2018", calificaciones))
                        calificacionesRecycler(kardex)
                    }
                } else {
                    Log.d("Error", "Error: No such document")
                }
            }

        //calificacionesRecycler(populateList())
    }

    /*private fun populateList(): MutableList<ReporteSemestral>{
        var reporte: MutableList<Materia> = mutableListOf()

        reporte.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
        "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))

        var reporte2 : MutableList<Materia> = mutableListOf()
        reporte2.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte2.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte2.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte2.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte2.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))
        reporte2.add(Materia("B1T1", "Calculo Diferencial", "5", "100",
            "Regularizacion Ordinaria Primera Vez", "Curso Aprobado"))

        var reporteSemestral: MutableList<ReporteSemestral> = mutableListOf()
        reporteSemestral.add(ReporteSemestral("Agosto - Diciembre", reporte))
        reporteSemestral.add(ReporteSemestral("Enero - Junio", reporte2))


        return reporteSemestral
    }*/

    private fun calificacionesRecycler(registros: MutableList<ReporteSemestral>){
        binding.recyclerCalificaciones.layoutManager = LinearLayoutManager(this@Calificaciones,
        RecyclerView.VERTICAL, false)

        var recycleAdapterCalificaciones: RecyclerAdapterCalificaciones = RecyclerAdapterCalificaciones(
            this@Calificaciones, registros)

        binding.recyclerCalificaciones.adapter = recycleAdapterCalificaciones
    }
}
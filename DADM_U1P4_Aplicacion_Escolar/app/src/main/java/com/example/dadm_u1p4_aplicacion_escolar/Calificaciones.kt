package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteSemestral
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityCalificacionesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
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
        db = FirebaseFirestore.getInstance()

        /** Preinitialize the list because of order issues. **/
        var kardex: MutableList<ReporteSemestral> = MutableList(Alumno.semestre-1){
                index -> ReporteSemestral("", null, 0f, 0)
        }

        for (i in 1 .. Alumno.semestre-1) {
            db.collection("alumnos/${auth.currentUser.uid}/materias")
                .whereEqualTo("semestre_cursada", i)
                .orderBy("clave", Query.Direction.ASCENDING).get()
                .addOnSuccessListener { documents ->
                    var calificaciones = mutableListOf<Materia>()
                    var promedio: Float = 0f
                    var creditos: Long = 0
                    var noMaterias = documents.size()
                    for (document in documents){
                        calificaciones.add(Materia(
                            clave = (document.get("clave") as String),
                            materia = (document.get("materia") as String),
                            creditos = (document.get("creditos") as Long),
                            calificacion = (document.get("calificacion") as String),
                            evaluacion = (document.get("evaluacion") as String),
                            observaciones = (document.get("observaciones") as String),
                            regularizacion = (document.get("regularizacion") as String),
                        ))
                        if(!((document.get("calificacion") as String) == "ACA")) {
                            promedio += (document.get("calificacion") as String).toInt()
                        }
                        creditos += (document.get("creditos") as Long)
                    }
                    promedio /= noMaterias
                    kardex[i-1].materias = calificaciones
                    kardex[i-1].periodo = "Agosto - Junio 2018"
                    kardex[i-1].promedio = promedio
                    kardex[i-1].creditos = creditos
                    if (i == Alumno.semestre-1)
                        calificacionesRecycler(kardex)
                }
        }
    }

    private fun calificacionesRecycler(registros: MutableList<ReporteSemestral>){
        binding.recyclerCalificaciones.layoutManager = LinearLayoutManager(this@Calificaciones,
        RecyclerView.VERTICAL, false)
        var recycleAdapterCalificaciones = RecyclerAdapterCalificaciones(
            this@Calificaciones, registros)
        binding.recyclerCalificaciones.adapter = recycleAdapterCalificaciones
    }
}
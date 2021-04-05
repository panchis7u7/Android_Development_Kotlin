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
                    var promedio: Float
                    var creditos: Int
                    var noMaterias: Int

                    for(i in 1 .. 2){

                        promedio = 0f
                        creditos = 0
                        noMaterias = 0
                        lista = (semestres.get(i.toString()) as List<Object>)
                        calificaciones = mutableListOf()
                        Log.d("Prueba", "Semestres : ${semestres.get(i.toString())}")

                        lista.map {
                            var mat = (it as HashMap<String, Any>)
                            noMaterias++
                            calificaciones.add(Materia(
                                clave = (mat.get("clave") as String),
                                materia = (mat.get("materia") as String),
                                creditos = (mat.get("creditos") as String),
                                calificacion = (mat.get("calificacion") as String),
                                evaluacion = (mat.get("evaluacion") as String),
                                observaciones = (mat.get("observaciones") as String),
                                regularizacion = (mat.get("regularizacion") as String),
                            ))
                            promedio += (mat.get("calificacion") as String).toInt()
                            creditos += (mat.get("creditos") as String).toInt()
                        }
                        promedio /= noMaterias
                        kardex.add(ReporteSemestral("Agosto - Junio 2018", calificaciones,
                        promedio, creditos))
                        calificacionesRecycler(kardex)
                    }
                } else {
                    Log.d("Error", "Error: No such document")
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
package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceSemestres
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityAvanceCurricularBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.*
import kotlin.collections.HashMap

class AvanceCurricular : AppCompatActivity() {
    private lateinit var binding: ActivityAvanceCurricularBinding

    //Firebase.
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvanceCurricularBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_avance_curricular)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val semestres: MutableList<Semestre> = MutableList(Alumno.semestresCarrera){
                index -> Semestre("",null)
        }

        for (i in 1 .. Alumno.semestresCarrera+1) {
            db.collection("alumnos/${auth.currentUser.uid}/materias")
                .whereEqualTo("semestre", i)
                .orderBy("clave", Query.Direction.ASCENDING)
                .get().addOnSuccessListener { documents ->
                    var materias = mutableListOf<Materia>()
                    for (document in documents) {
                        materias.add(Materia(
                            clave = (document.get("clave") as String),
                            materia = (document.get("materia") as String),
                            calificacion = (document.get("calificacion") as String),
                            regularizacion = (document.get("regularizacion") as String),
                            profesor = (document.get("profesor") as String)
                        ))
                        semestres[i-1].materias = materias
                        semestres[i-1].semestre = i.toString()
                    }
                    if(i == Alumno.semestresCarrera)
                        semestresRecycler(semestres)
                }
        }
    }

    private fun semestresRecycler(semestres: MutableList<Semestre>){
        binding.recyclerSemestres.layoutManager = LinearLayoutManager(this@AvanceCurricular,
        RecyclerView.VERTICAL, false)
        val recycleAdapterSemestre: RecyclerAdapterAvanceSemestres = RecyclerAdapterAvanceSemestres(
            this@AvanceCurricular, semestres, false, null)
        binding.recyclerSemestres.adapter= recycleAdapterSemestre
        recycleAdapterSemestre.notifyDataSetChanged()
    }
}
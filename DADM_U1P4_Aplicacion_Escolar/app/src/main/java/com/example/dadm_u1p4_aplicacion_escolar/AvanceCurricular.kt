package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceSemestres
import com.example.dadm_u1p4_aplicacion_escolar.Controllers.FetchManager
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.MateriaGrupos
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityAvanceCurricularBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.collections.HashMap

class AvanceCurricular : AppCompatActivity() {
    private var _binding: ActivityAvanceCurricularBinding? = null
    private val binding get() = _binding!!

    //Firebase.
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAvanceCurricularBinding.inflate(layoutInflater)
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
                        if(!document.contains("laboratorio")) {
                            materias.add(Materia(
                                clave = (document.get("clave") as String),
                                materia = (document.get("materia") as String),
                                calificacion = (document.get("calificacion") as String),
                                regularizacion = (document.get("regularizacion") as String),
                                profesor = (document.get("profesor") as String)
                            ))
                            semestres[i - 1].materias = materias
                            semestres[i - 1].semestre = i.toString()
                        }
                    }
                    if(i == Alumno.semestresCarrera)
                        semestresRecycler(semestres)
                }
        }

        val jwt = "eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2MjI5NTIxNDEsImV4cCI6MTYyMjk1OTM0MSwiaWRBbHVtbm8iOiIxNTc1YzY3Zi1lMjQ4LTQ2YmItOGNjNy03NDgyNzhmMzNiNmEiLCJjb3JyZW8iOiJzbWFkQGdtYWlsLmNvbSAgICAgICAgICAgICAgICAgICAgICIsIm5vbWJyZSI6IkNhcmxvcyBTZWJhc3RpYW4gTWFkcmlnYWwgUm9kcmlnZXV6Iiwibm9Db250cm9sIjoiMTgxMjE2OTkgICJ9.ctK4W6nV6WOjIXGY9Ur0LiG_8nLSDATdcYl5W9pSprPWxA2oXncJ5LcEdyBviZ44V6mnxKsE1owdT9GHuBqbTg"
        val api = FetchManager(jwt)
        var grupos: List<MateriaGrupos>? = api.getGrupos()
        GlobalScope.launch {
            grupos = async { api.getGrupos() }.await()
        }

        Log.d("Prueba", grupos!![0].asignatura)
    }

    private fun semestresRecycler(semestres: MutableList<Semestre>){
        binding.recyclerSemestres.layoutManager = LinearLayoutManager(this@AvanceCurricular,
        RecyclerView.VERTICAL, false)
        val recycleAdapterSemestre: RecyclerAdapterAvanceSemestres = RecyclerAdapterAvanceSemestres(
            this@AvanceCurricular, semestres, false, null)
        binding.recyclerSemestres.adapter= recycleAdapterSemestre
        recycleAdapterSemestre.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
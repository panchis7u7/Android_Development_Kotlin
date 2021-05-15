package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterHorarios
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteSemestral
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityHorariosBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.Repo
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class Horarios : AppCompatActivity() {

    private lateinit var binding: ActivityHorariosBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorariosBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_horarios)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        var semana: MutableList<ReporteSemestral> = mutableListOf()

        db.collection("alumnos/${auth.currentUser.uid}/materias")
            .whereEqualTo("semestre_cursada", Alumno.semestre)
            .get().addOnSuccessListener { documents ->
                var dias: List<String> = listOf("lunes", "martes", "miercoles", "jueves", "viernes")
                var horarios: MutableList<Materia>
                for (i in 0 .. dias.size-1){
                    horarios = mutableListOf()
                    documents.forEach { document ->
                        var horario = (document.get("horarios") as List<String>)[i]
                        if (horario.isNotEmpty()) {
                            horarios.add(Materia(
                                horario = horario,
                                aula = (document.get("aulas") as List<String>)[i],
                                materia = (document.get("materia") as String),
                                profesor = (document.get("profesor") as String),
                                grupo = (document.getString("grupo") as String)
                            ))
                        }
                    }
                    semana.add(ReporteSemestral(dias[i].capitalize(), horarios))
                }
                horariosRecycler(semana)
            }
    }

    private fun horariosRecycler(registros: MutableList<ReporteSemestral>){
        binding.recyclerHorarios.layoutManager = LinearLayoutManager(this@Horarios,
            RecyclerView.VERTICAL, false)
        var recyclerAdapterHorarios = RecyclerAdapterHorarios(
            this@Horarios, registros)
        binding.recyclerHorarios.adapter = recyclerAdapterHorarios
    }
}
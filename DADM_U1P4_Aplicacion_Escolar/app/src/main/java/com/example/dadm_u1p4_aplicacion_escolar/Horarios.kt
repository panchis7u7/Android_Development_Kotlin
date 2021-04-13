package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterCalificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterHorarios
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteSemestral
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityHorariosBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.Repo
import com.google.firebase.firestore.FirebaseFirestore

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
        var semana: MutableList<ReporteSemestral> = mutableListOf()

        db = FirebaseFirestore.getInstance()
        db.collection("alumnos/${auth.currentUser.uid}/cursando").document("horarios").get()
            .addOnSuccessListener { document ->
                if (document != null && document.data != null){
                    var dias: List<String> = listOf("lunes", "martes", "miercoles", "jueves", "viernes")
                    var horarios: MutableList<Materia>
                    for(dia in dias) {
                        horarios = mutableListOf()
                        var horario: List<HashMap<String,Any>> = (document.get(dia) as List<HashMap<String,Any>>)
                        horario.map {
                            horarios.add(Materia(
                                aula = (it.get("aula") as String),
                                clave = (it.get("clave") as String),
                                grupo = (it.get("grupo") as String),
                                horario = (it.get("horario") as String),
                                materia = (it.get("materia") as String),
                                profesor = (it.get("profesor") as String),
                            ))
                        }
                        semana.add(ReporteSemestral(dia, horarios))
                        horariosRecycler(semana)
                    }
                } else {
                    Log.d("Error", "Error: No such document")
                }
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
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
                if (document != null){
                    var dias: List<String> = listOf("lunes", "martes"/*, "Miercoles", "Jueves", "Viernes"*/)
                    var horarios: MutableList<Materia>
                    for(dia in dias) {
                        horarios = mutableListOf()
                        var horario: List<HashMap<String,Any>> = (document.get(dia) as List<HashMap<String,Any>>)
                        //Log.d("Prueba", "Data: $horario")
                        horario.map {
                            var mat = (it as HashMap<String, Any>)
                            Log.d("prueba2", "Datos2: ${(mat)}")
                            horarios.add(Materia(
                                aula = (mat.get("aula") as String),
                                clave = (mat.get("clave") as String),
                                grupo = (mat.get("grupo") as String),
                                horario = (mat.get("horario") as String),
                                materia = (mat.get("materia") as String),
                                profesor = (mat.get("profesor") as String),
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

    private fun populateList(): MutableList<ReporteSemestral>{
        var horario1: MutableList<Materia> = mutableListOf()

        horario1.add(Materia("LRD", "B8T1", "A", "8:00=10:00",
        "Administracion y Seguridad de Redes", "Lara Barcenas Ruben"))
        horario1.add(Materia("LRD", "B8T1", "A", "8:00=10:00",
            "Administracion y Seguridad de Redes", "Lara Barcenas Ruben"))
        horario1.add(Materia("LRD", "B8T1", "A", "8:00=10:00",
            "Administracion y Seguridad de Redes", "Lara Barcenas Ruben"))
        horario1.add(Materia("LRD", "B8T1", "A", "8:00=10:00",
            "Administracion y Seguridad de Redes", "Lara Barcenas Ruben"))
        horario1.add(Materia("LRD", "B8T1", "A", "8:00=10:00",
            "Administracion y Seguridad de Redes", "Lara Barcenas Ruben"))
        horario1.add(Materia("LRD", "B8T1", "A", "8:00=10:00",
            "Administracion y Seguridad de Redes", "Lara Barcenas Ruben"))

        var horario2: MutableList<Materia> = mutableListOf()
        horario2.add(Materia("LRD", "B4T1", "A", "11:00=10300",
            "Redes de Computadoras", "Pacheco Pimentel Efren"))
        horario2.add(Materia("LRD", "B4T1", "A", "11:00=10300",
            "Redes de Computadoras", "Pacheco Pimentel Efren"))
        horario2.add(Materia("LRD", "B4T1", "A", "11:00=10300",
            "Redes de Computadoras", "Pacheco Pimentel Efren"))
        horario2.add(Materia("LRD", "B4T1", "A", "11:00=10300",
            "Redes de Computadoras", "Pacheco Pimentel Efren"))
        horario2.add(Materia("LRD", "B4T1", "A", "11:00=10300",
            "Redes de Computadoras", "Pacheco Pimentel Efren"))
        horario2.add(Materia("LRD", "B4T1", "A", "11:00=10300",
            "Redes de Computadoras", "Pacheco Pimentel Efren"))

        var horarios: MutableList<ReporteSemestral> = mutableListOf()
        horarios.add(ReporteSemestral("Lunes", horario1))
        horarios.add(ReporteSemestral("Martes", horario2))

        return horarios
    }

    private fun horariosRecycler(registros: MutableList<ReporteSemestral>){
        binding.recyclerHorarios.layoutManager = LinearLayoutManager(this@Horarios,
            RecyclerView.VERTICAL, false)
        var recyclerAdapterHorarios = RecyclerAdapterHorarios(
            this@Horarios, registros)
        binding.recyclerHorarios.adapter = recyclerAdapterHorarios
    }
}
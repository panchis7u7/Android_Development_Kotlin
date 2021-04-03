package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceMaterias
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceSemestres
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityAvanceCurricularBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import java.util.*
import kotlin.collections.HashMap

class AvanceCurricular : AppCompatActivity() {
    private lateinit var binding: ActivityAvanceCurricularBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gridItemAdapter: RecyclerAdapterAvanceMaterias
    private var models: MutableList<Materia> = mutableListOf<Materia>()

    //Firebase.
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvanceCurricularBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_avance_curricular)
        setContentView(binding.root)

        semestresRecycler(populateList())
    }

    private fun populateList(): MutableList<Semestre>{

        /*db = FirebaseFirestore.getInstance()
        var materias1: MutableList<Materia> = mutableListOf()

        db.collection("carreras/ITICs/reticula").document("semestre").get()
            .addOnSuccessListener { document ->
                if(document != null) {
                    Log.d("Data", "Datos: ${document.data}")
                    //val res = document.toObject(Materia::class.java)

                    var lista: List<Object> = document.get("1") as List<Object>
                    for(i in 0 .. (lista.size-1)){
                        var mat = (lista.get(i) as HashMap<String, Any>)
                        materias1.add(Materia((mat.get("clave") as String), (mat.get("materia") as String),
                            (mat.get("creditos") as String)))
                        Log.d("Data", "Datos: ${materias1.get(i).clave}, ${materias1.get(i).materia}, ${materias1.get(i).creditos}")
                        }
                } else
                    Log.d("Error", "Error: No such document")
            }
        Log.d("tamanio: ", "tamano: ${materias1.size}")

        return mutableListOf(Semestre("hola",materias1))*/



        var materias1: MutableList<Materia> = mutableListOf<Materia>()
        materias1.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias1.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias1.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias1.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias1.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias1.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))

        var materias2: MutableList<Materia> = mutableListOf<Materia>()
        materias2.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias2.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias2.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias2.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias2.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))
        materias2.add(Materia("B1T1", "Calculo Diferencial", "5", 94,
            "O1", "Curso Aprobado"))

        var semestres: MutableList<Semestre> = mutableListOf<Semestre>()
        semestres.add(Semestre("Semestre 1", materias1))
        semestres.add(Semestre("Semestre 2", materias2))

        return semestres
    }

    private fun semestresRecycler(semestres: MutableList<Semestre>){
        binding.recyclerSemestres.layoutManager = LinearLayoutManager(this@AvanceCurricular,
        RecyclerView.VERTICAL, false)
        var recycleAdapterSemestre: RecyclerAdapterAvanceSemestres = RecyclerAdapterAvanceSemestres(
            this@AvanceCurricular, semestres)
        binding.recyclerSemestres.adapter= recycleAdapterSemestre

    }
}
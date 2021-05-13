package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceSemestres
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

        var semestres: MutableList<Semestre> = MutableList(9){
                index -> Semestre("",null)
        }

        for (i in 1 .. 10) {
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
                            regularizacion = (document.get("regularizacion") as String)
                        ))
                        semestres[i-1].materias = materias
                        semestres[i-1].semestre = i.toString()
                    }
                    if(i == 9)
                        semestresRecycler(semestres)
                }
        }

        /*
        db = FirebaseFirestore.getInstance()
        db.collection("carreras/ITICs/reticula").document("semestre").get()
            .addOnSuccessListener { document ->
                if(document != null) {

                    var lista: List<Object>
                    var materias: MutableList<Materia>
                    var i = 1

                    while (document.get(i.toString()) != null) {

                        lista = document.get(i.toString()) as List<Object>
                        materias = mutableListOf()

                        lista.map {
                            var mat = (it as HashMap<String, Any>)

                            materias.add(Materia(
                                clave = (mat.get("clave") as String),
                                materia = (mat.get("materia") as String),
                                creditos = (mat.get("creditos") as String)))
                        }
                        semestres.add(Semestre("Semestre $i", materias))
                        i++
                    }

                    db.collection("materias").document(auth.currentUser.uid).get()
                        .addOnSuccessListener { doc ->
                            if(doc != null && doc.data != null) {
                                var matExtraList: MutableList<Materia> = mutableListOf()
                                var listaUsuarioSemestre: HashMap<String, Any> =
                                    doc.get("semestre") as HashMap<String, Any>
                                var j: Int
                                var semestreIndex: Int = 1
                                while (listaUsuarioSemestre.get(semestreIndex.toString()) != null) {
                                //for (i in 1 .. 3) {
                                        j = 0
                                    (listaUsuarioSemestre.get(semestreIndex.toString()) as List<Object>).map {
                                        (it as HashMap<String, Any>)
                                        if((it.get("semestre") as String).toInt() == semestreIndex) {
                                            semestres.get(semestreIndex - 1).materias.get(j).calificacion =
                                                (it.get("calificacion") as String)
                                            semestres.get(semestreIndex - 1).materias.get(j).evaluacion =
                                                (it.get("evaluacion") as String)
                                            semestres.get(semestreIndex - 1).materias.get(j).observaciones =
                                                (it.get("observaciones") as String)
                                            semestres.get(semestreIndex - 1).materias.get(j).regularizacion =
                                                (it.get("regularizacion") as String)
                                            j++
                                        } else {
                                            matExtraList.add(Materia(
                                                calificacion = (it.get("calificacion") as String),
                                                evaluacion = (it.get("evaluacion") as String),
                                                observaciones = (it.get("observaciones") as String),
                                                regularizacion = (it.get("regularizacion") as String),
                                                semestre = (it.get("semestre") as String),
                                                materia = (it.get("materia") as String),
                                                clave = (it.get("clave") as String)
                                            ))
                                        }
                                    }

                                    matExtraList.map {
                                        var semestre: Int = ((it.semestre) as String).toInt()
                                        var indice: Int = ((it.clave) as String).split("T")[1].toInt()
                                        try {
                                            Log.d("index", "indice ${indice}")
                                            semestres.get(semestre - 1).materias.get(indice - 1).calificacion =
                                                (it.calificacion)
                                            semestres.get(semestre - 1).materias.get(indice - 1).evaluacion =
                                                (it.evaluacion)
                                            semestres.get(semestre - 1).materias.get(indice - 1).observaciones =
                                                (it.observaciones)
                                            semestres.get(semestre - 1).materias.get(indice - 1).regularizacion =
                                                (it.regularizacion)
                                        } catch (e: Exception){
                                            Log.d("Invalid Pointer", "Error!")
                                        }
                                    }
                                    semestreIndex++
                                }
                                semestresRecycler(semestres)
                            } else {
                                Log.d("Error", "Error: No such document")
                                semestresRecycler(semestres)
                            }
                        }
                } else
                    Log.d("Error", "Error: No such document")
            }*/
    }

    private fun semestresRecycler(semestres: MutableList<Semestre>){
        binding.recyclerSemestres.layoutManager = LinearLayoutManager(this@AvanceCurricular,
        RecyclerView.VERTICAL, false)
        var recycleAdapterSemestre: RecyclerAdapterAvanceSemestres = RecyclerAdapterAvanceSemestres(
            this@AvanceCurricular, semestres)
        binding.recyclerSemestres.adapter= recycleAdapterSemestre
        recycleAdapterSemestre.notifyDataSetChanged()
    }
}
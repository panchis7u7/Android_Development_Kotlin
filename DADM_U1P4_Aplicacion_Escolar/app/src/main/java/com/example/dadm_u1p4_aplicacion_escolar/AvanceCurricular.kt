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
        var semestres: MutableList<Semestre> = mutableListOf()

        db = FirebaseFirestore.getInstance()
        db.collection("carreras/ITICs/reticula").document("semestre").get()
            .addOnSuccessListener { document ->
                if(document != null) {

                    var lista: List<Object>
                    var materias: MutableList<Materia>

                    for(i in 1 .. 2) {

                        lista = document.get(i.toString()) as List<Object>
                        materias = mutableListOf()

                        lista.map {
                            var mat = (it as HashMap<String, Any>)

                            materias.add(Materia((mat.get("clave") as String),
                                (mat.get("materia") as String),
                                (mat.get("creditos") as String)))
                        }
                        semestres.add(Semestre("Semestre $i", materias))
                    }

                    db.collection("materias").document(auth.currentUser.uid).get()
                        .addOnSuccessListener { doc ->
                            if(doc != null) {
                                var listaUsuarioSemestre: HashMap<String, Any> =
                                    doc.get("semestre") as HashMap<String, Any>
                                var j: Int = 0
                                for (i in 1..listaUsuarioSemestre.size) {
                                        j = 0
                                    (listaUsuarioSemestre.get(i.toString()) as List<Object>).map {
                                        var mat = (it as HashMap<String, Any>)
                                        semestres.get(i-1).materias.get(j).calificacion =
                                            (it.get("calificacion") as String)
                                        semestres.get(i-1).materias.get(j).evaluacion =
                                            (it.get("evaluacion") as String)
                                        semestres.get(i-1).materias.get(j).observaciones =
                                            (it.get("observaciones") as String)
                                        semestres.get(i-1).materias.get(j).regularizacion =
                                            (it.get("regularizacion") as String)
                                        j++
                                    }
                                }
                                semestresRecycler(semestres)
                            } else {
                                Log.d("Error", "Error: No such document")
                            }
                        }
                } else
                    Log.d("Error", "Error: No such document")
            }
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
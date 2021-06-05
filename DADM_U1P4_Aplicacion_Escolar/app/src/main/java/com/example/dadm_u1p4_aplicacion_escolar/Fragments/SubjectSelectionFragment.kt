package com.example.dadm_u1p4_aplicacion_escolar.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Adapters.RecyclerAdapterAvanceSemestres
import com.example.dadm_u1p4_aplicacion_escolar.Interfaces.IOnClickSelection
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.R
import com.example.dadm_u1p4_aplicacion_escolar.Stateflows.MateriasStateFlow
import com.example.dadm_u1p4_aplicacion_escolar.databinding.FragmentSubjectSelectionBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class SubjectSelectionFragment: Fragment(R.layout.fragment_subject_selection) {
    private var _binding: FragmentSubjectSelectionBinding? = null
    private val binding get() = _binding!!
    private var auth: FirebaseAuth? = null
    private val stateFlow: MateriasStateFlow by activityViewModels()
    private val materiasSeleccionadas: MutableList<Materia> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubjectSelectionBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()

        val semestres: MutableList<Semestre> = MutableList(Alumno.semestresCarrera){
                index -> Semestre("",null)
        }

        auth?.let {
            for (i in 1 .. Alumno.semestresCarrera+1) {
                val document = Firebase.firestore.collection("alumnos/${it.currentUser.uid}/materias")
                    .whereEqualTo("semestre", i)
                    .orderBy("clave", Query.Direction.ASCENDING)
                lifecycleScope.launch(Dispatchers.IO) {
                    val materia = document.get().await()
                    val materias = mutableListOf<Materia>()
                    materia.documents.forEach { document ->
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
                    if (i == Alumno.semestresCarrera)
                        withContext(Dispatchers.Main) { semestresRecycler(semestres) }
                }
            }
        }

        return binding.root
    }

    private fun semestresRecycler(semestres: List<Semestre>){
        binding.recyclerViewSelection.layoutManager = LinearLayoutManager(requireContext(),
            RecyclerView.VERTICAL, false)
        binding.recyclerViewSelection.adapter= RecyclerAdapterAvanceSemestres(
            requireContext(), semestres, true, object : IOnClickSelection {
                override fun onSelectionClick(materia: Materia) {
                    Toast.makeText(requireContext(), materia.materia, Toast.LENGTH_LONG).show()
                    materiasSeleccionadas.add(materia)
                    stateFlow.setMaterias(materiasSeleccionadas)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
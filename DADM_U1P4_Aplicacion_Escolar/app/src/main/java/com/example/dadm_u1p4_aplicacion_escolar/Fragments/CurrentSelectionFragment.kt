package com.example.dadm_u1p4_aplicacion_escolar.Fragments

import AddGroupMutation
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.example.dadm_u1p4_aplicacion_escolar.Controllers.FetchManager
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R
import com.example.dadm_u1p4_aplicacion_escolar.SeleccionActivity
import com.example.dadm_u1p4_aplicacion_escolar.Viewmodels.MateriaViewModel
import com.example.dadm_u1p4_aplicacion_escolar.databinding.FragmentCurrentSelectionBinding
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentSelectionFragment: Fragment(R.layout.fragment_current_selection) {
    private var _binding: FragmentCurrentSelectionBinding? = null
    private val binding get() = _binding!!
    private val materiasViewModel: MateriaViewModel by activityViewModels()
    private lateinit var parentActivity: SeleccionActivity
    private var materias: MutableList<Materia> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCurrentSelectionBinding.inflate(layoutInflater)

        parentActivity = (requireActivity() as SeleccionActivity)
        val graph = FetchManager(requireContext())

        materiasViewModel.materia.observe(viewLifecycleOwner) { materia ->

            materias.add(materia.first)
            val row = TableRow(context)
            val tableRowParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT)

            val textViewParams = TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT)
            textViewParams.setMargins(0, 5, 15, 5)

            tableRowParams.setMargins(0, 0, 0, 0)
            row.setPadding(30, 0, 30, 0)
            row.layoutParams = tableRowParams

            val textViewClave = TextView(context)
            textViewClave.setPadding(5, 10, 0, 10)
            textViewClave.text = materia.first.clave
            textViewClave.textSize = 16f
            textViewClave.layoutParams = textViewParams
            textViewClave.setTextColor(requireContext().resources.getColor(R.color.white))
            row.addView(textViewClave)

            val textViewMateria = TextView(context)
            textViewMateria.setPadding(5, 10, 0, 10)
            textViewMateria.text = materia.first.materia
            textViewMateria.textSize = 16f
            textViewMateria.layoutParams = textViewParams
            textViewMateria.setTextColor(requireContext().resources.getColor(R.color.white))
            row.addView(textViewMateria)

            val textViewCreditos = TextView(context)
            textViewCreditos.setPadding(5, 10, 0, 10)
            textViewCreditos.text = materia.first.creditos.toString()
            textViewCreditos.textSize = 16f
            textViewCreditos.layoutParams = textViewParams
            textViewCreditos.setTextColor(requireContext().resources.getColor(R.color.white))
            row.addView(textViewCreditos)

            val textViewGrupo = TextView(context)
            textViewGrupo.setPadding(5, 10, 0, 10)
            textViewGrupo.text = (materia.second.getChildAt(0) as TextView).text
            textViewGrupo.textSize = 16f
            textViewGrupo.layoutParams = textViewParams
            textViewGrupo.setTextColor(requireContext().resources.getColor(R.color.white))
            row.addView(textViewGrupo)

            for (i in 1..5) {
                val textViewHorarios = TextView(context)
                textViewHorarios.setPadding(5, 10, 0, 10)
                textViewHorarios.layoutParams = textViewParams
                textViewHorarios.textSize = 16f
                textViewHorarios.text = (materia.second.getChildAt(i) as TextView).text
                textViewHorarios.setTextColor(requireContext().resources.getColor(R.color.white))
                row.addView(textViewHorarios)
            }

            val buttonParams = TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, 100)
            buttonParams.setMargins(0, 5, 15, 5)
            val materialButton = MaterialButton(requireContext())
            materialButton.text = "Remover"
            materialButton.setBackgroundColor(requireContext().resources.getColor(R.color.red))
            materialButton.setTextColor(requireContext().resources.getColor(R.color.white))
            materialButton.isAllCaps = false
            materialButton.setPadding(5, 0, 5, 0)
            materialButton.layoutParams = buttonParams
            materialButton.textSize = 12f

            row.addView(materialButton)
            binding.tableLayoutGrupos.addView(row)

            materialButton.setOnClickListener {
                binding.tableLayoutGrupos.removeView(it.parent as TableRow)
                Toast.makeText(requireContext(), "Creditos: ${materia.first.creditos!!}", Toast.LENGTH_LONG).show()
                (requireActivity() as SeleccionActivity).noCreditos -= materia.first.creditos!!.toInt()
                binding.textViewCreditosSeleccionados.text = parentActivity.noCreditos.toString()
            }

            binding.textViewCreditosSeleccionados.text = parentActivity.noCreditos.toString()
        }
            binding.buttonSubmitCarga.setOnClickListener {
                GlobalScope.launch(Dispatchers.IO) {
                    materias.forEach { materia ->
                        try {
                            val result = graph.apolloClient.mutate(AddGroupMutation(
                                Alumno.id.toString(),
                                materia.id_grupo.toString(),
                                "Cursando",
                                Input.optional(Alumno.semestre),
                                Input.absent(),
                                Input.optional(""),
                                Input.optional(""),
                                Input.optional("")
                            )).await()
                        } catch (e: ApolloException) {
                            println(e.message)
                        }
                    }
                }
            }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
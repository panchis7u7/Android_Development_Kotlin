package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Interfaces.IOnClickSelection
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterAvanceSemestres(
    private val context: Context,
    private val semestres: List<Semestre>,
    private val seleccion: Boolean,
    private val onCLick: IOnClickSelection?) :
RecyclerView.Adapter<RecyclerAdapterAvanceSemestres.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewSemestre: TextView = itemView.findViewById(R.id.textViewSemestre)
        val recyclerViewMaterias: RecyclerView = itemView.findViewById(R.id.recyclerViewSemestre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.recycler_avance_item_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val semestre: Semestre = semestres.get(position)
        holder.textViewSemestre.text = semestre.semestre
        setCallItemRecycler(holder.recyclerViewMaterias, semestre.materias!!, seleccion)
    }

    override fun getItemCount(): Int {
        return semestres.size
    }

    private fun setCallItemRecycler(recyclerView: RecyclerView, materias: List<Materia>, seleccion: Boolean){
        val itemRecycleAdapter = RecyclerAdapterAvanceMaterias(context, materias, seleccion, onCLick)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemRecycleAdapter
        recyclerView.layoutManager = GridLayoutManager(context,2)
    }
}
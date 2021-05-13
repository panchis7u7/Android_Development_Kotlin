package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterAvanceSemestres(private var context: Context,
                                     private var semestres: MutableList<Semestre>) :
RecyclerView.Adapter<RecyclerAdapterAvanceSemestres.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewSemestre: TextView = itemView.findViewById(R.id.textViewSemestre)
        val recyclerViewMaterias: RecyclerView = itemView.findViewById(R.id.recyclerViewSemestre)
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.recycler_avance_item_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var semestre: Semestre = semestres.get(position)
        holder.textViewSemestre.text = semestre.semestre
        setCallItemRecycler(holder.recyclerViewMaterias, semestre.materias!!)
    }

    override fun getItemCount(): Int {
        return semestres.size
    }

    private fun setCallItemRecycler(recyclerView: RecyclerView, materias: MutableList<Materia>){
        var itemRecycleAdapter = RecyclerAdapterAvanceMaterias(context, materias)
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemRecycleAdapter
    }
}
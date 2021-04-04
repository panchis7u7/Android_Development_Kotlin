package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterAvanceMaterias (private var context: Context,
                                     private var materias: MutableList<Materia>) :
RecyclerView.Adapter<RecyclerAdapterAvanceMaterias.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewClave: TextView = itemView.findViewById(R.id.textViewClave)
        val textViewMateria: TextView = itemView.findViewById(R.id.textViewMateria)
        val textViewCalificacion: TextView = itemView.findViewById(R.id.textViewCalificacion)
        val textViewRegularizacion: TextView = itemView.findViewById(R.id.textViewRegularizacion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_avance_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var materia: Materia = materias.get(position)
        holder.textViewClave.text = materia.clave
        holder.textViewMateria.text = materia.materia
        holder.textViewCalificacion.text = materia.calificacion
        holder.textViewRegularizacion.text = materia.regularizacion
    }

    override fun getItemCount(): Int {
        return materias.size
    }
}
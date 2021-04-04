package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterCalificacionesItems(private var context: Context,
                                         private var materias: MutableList<Materia>) :
    RecyclerView.Adapter<RecyclerAdapterCalificacionesItems.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewClave: TextView = itemView.findViewById<TextView>(R.id.textViewClave)
        val textViewMateria: TextView = itemView.findViewById<TextView>(R.id.textViewMateria)
        val textViewCreditos: TextView = itemView.findViewById<TextView>(R.id.textViewCreditos)
        val textViewCalificacion: TextView = itemView.findViewById<TextView>(R.id.textViewCalificacion)
        val textViewEvaluacion: TextView = itemView.findViewById<TextView>(R.id.textViewEvaluacion)
        val textViewObservaciones: TextView = itemView.findViewById<TextView>(R.id.textViewObservaciones)

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_calificaciones_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var materia : Materia = materias.get(position)
        holder.textViewClave.text = materia.clave
        holder.textViewMateria.text = materia.materia
        holder.textViewCreditos.text = materia.creditos
        holder.textViewCalificacion.text = materia.calificacion
        holder.textViewEvaluacion.text = materia.evaluacion
        holder.textViewObservaciones.text = materia.observaciones
    }

    override fun getItemCount(): Int {
        return materias.size
    }

}
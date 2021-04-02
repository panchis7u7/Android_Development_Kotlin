package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteMateria
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterCalificaciones(private var context: Context,
                                    public var materias: MutableList<ReporteMateria>) :
    RecyclerView.Adapter<RecyclerAdapterCalificaciones.ItemHolder>(){

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
        var reporteMateria : ReporteMateria = materias.get(position)
        holder.textViewClave.text = reporteMateria.materia.clave
        holder.textViewMateria.text = reporteMateria.materia.materia
        holder.textViewCreditos.text = reporteMateria.materia.creditos
        holder.textViewCalificacion.text = reporteMateria.calificacion
        holder.textViewEvaluacion.text = reporteMateria.evaluacion
        holder.textViewObservaciones.text = reporteMateria.observaciones
    }

    override fun getItemCount(): Int {
        return materias.size
    }

    private fun setCallItemRecycler(recyclerView: RecyclerView, materias: MutableList<ReporteMateria>){

    }

}
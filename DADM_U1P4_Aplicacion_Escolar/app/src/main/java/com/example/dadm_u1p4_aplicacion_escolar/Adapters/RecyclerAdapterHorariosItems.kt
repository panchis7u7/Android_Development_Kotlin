package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterHorariosItems(private var context: Context, private var horarios: MutableList<Materia>) :
RecyclerView.Adapter<RecyclerAdapterHorariosItems.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textViewHorario: TextView = itemView.findViewById(R.id.textViewHorario)
        val textViewMateria: TextView = itemView.findViewById(R.id.textViewMateria)
        val textViewAula: TextView = itemView.findViewById(R.id.textViewAula)
        val textViewGrupo: TextView = itemView.findViewById(R.id.textViewGrupo)
        val textViewProfesor: TextView = itemView.findViewById(R.id.textViewProfesor)

        init {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_horario_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var materia: Materia = horarios.get(position)
        holder.textViewHorario.text = materia.horario
        holder.textViewMateria.text = materia.materia
        holder.textViewAula.text = materia.aula
        holder.textViewGrupo.text = materia.grupo
        holder.textViewProfesor.text = materia.profesor
    }

    override fun getItemCount(): Int {
        return horarios.size
    }

}
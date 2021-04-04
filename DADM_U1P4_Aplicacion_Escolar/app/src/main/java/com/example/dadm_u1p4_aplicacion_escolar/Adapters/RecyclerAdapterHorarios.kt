package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.ReporteSemestral
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterHorarios(private var context: Context,
                              private var registros: MutableList<ReporteSemestral>) :
RecyclerView.Adapter<RecyclerAdapterHorarios.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewDia: TextView = itemView.findViewById(R.id.textViewDia)
        val recyclerViewHorarios: RecyclerView = itemView.findViewById(R.id.recyclerViewHorarios)
        init {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.recycler_horarios_item_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var horarios: ReporteSemestral = registros.get(position)
        holder.textViewDia.text = horarios.periodo
        setCallItemRecycler(holder.recyclerViewHorarios, horarios.materias)
    }

    override fun getItemCount(): Int {
        return registros.size
    }

    private fun setCallItemRecycler(recyclerView: RecyclerView, horarios: MutableList<Materia>){
        var itemRecyclerAdapter = RecyclerAdapterHorariosItems(context, horarios)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }
}
package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.AvanceCurricular
import com.example.dadm_u1p4_aplicacion_escolar.Calificaciones
import com.example.dadm_u1p4_aplicacion_escolar.Dashboard
import com.example.dadm_u1p4_aplicacion_escolar.Models.GridButton
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterDashboard(private var context: Context,
                               public var buttons: MutableList<GridButton>) :
RecyclerView.Adapter<RecyclerAdapterDashboard.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloGridItem: TextView = itemView.findViewById<TextView>(R.id.tituloGridItem)
        val imagenGridItem: ImageView = itemView.findViewById<ImageView>(R.id.iconoGridItem)

        init {
            itemView.setOnClickListener {
                lateinit var intent: Intent
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "Hiciste click en el item : ${position + 1}", Toast.LENGTH_LONG).show()
                when(position){
                    0 -> {intent = Intent(it.context, Calificaciones::class.java)}
                    1 -> {}
                    2 -> {intent = Intent(it.context, AvanceCurricular::class.java)}
                    }
                itemView.context.startActivity(intent)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_item_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var gridButton: GridButton = buttons.get(position)
        holder.tituloGridItem.text = gridButton.texto
        holder.imagenGridItem.setImageResource(gridButton.icono)
    }

    override fun getItemCount(): Int {
        return buttons.size
    }
}
package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.GridButton
import com.example.dadm_u1p4_aplicacion_escolar.R

class RecyclerAdapterCalificaciones(private var context: Context,
                                    public var buttons: MutableList<GridButton>) :
    RecyclerView.Adapter<RecyclerAdapterCalificaciones.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloGridItem: TextView = itemView.findViewById<TextView>(R.id.tituloGridItem)
        val imagenGridItem: ImageView = itemView.findViewById<ImageView>(R.id.iconoGridItem)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "Hiciste click en el item : ${position + 1}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
package com.example.dadm_u1p4_aplicacion_escolar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.GridButton
import com.squareup.picasso.Picasso

class RecyclerAdapter(private var context: Context,
                      public var buttons: MutableList<GridButton>) :
RecyclerView.Adapter<RecyclerAdapter.ItemHolder>(){

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tituloGridItem: TextView = view.findViewById<TextView>(R.id.tituloGridItem)
        val imagenGridItem: ImageView = view.findViewById<ImageView>(R.id.iconoGridItem)

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var gridButton: GridButton = buttons.get(position)
        holder.tituloGridItem.text = gridButton.texto
        Picasso.get().load(gridButton.imagen).into(holder.imagenGridItem)

        holder.tituloGridItem.setOnClickListener {
            Toast.makeText(context, gridButton.texto, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return buttons.size
    }
}
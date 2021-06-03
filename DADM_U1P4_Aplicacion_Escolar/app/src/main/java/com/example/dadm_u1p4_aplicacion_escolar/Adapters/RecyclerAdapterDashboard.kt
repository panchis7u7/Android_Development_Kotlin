package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.*
import com.example.dadm_u1p4_aplicacion_escolar.Models.GridButton

class RecyclerAdapterDashboard(private var context: Context,
                               private var buttons: MutableList<GridButton>) :
RecyclerView.Adapter<RecyclerAdapterDashboard.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloGridItem: TextView = itemView.findViewById(R.id.tituloGridItem)
        val imagenGridItem: ImageView = itemView.findViewById(R.id.iconoGridItem)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                when(position){
                    0 -> {itemView.context.startActivity(Intent(it.context, Calificaciones::class.java))}
                    1 -> {itemView.context.startActivity(Intent(it.context, Horarios::class.java))}
                    2 -> {itemView.context.startActivity(Intent(it.context, AvanceCurricular::class.java))}
                    3 -> {itemView.context.startActivity(Intent(it.context, Perfil::class.java))}
                    4 -> {
                        Login.auth.signOut()
                        itemView.context.startActivity(Intent(it.context, Login::class.java))
                        }
                    5 -> {itemView.context.startActivity(Intent(it.context, SeleccionActivity::class.java))}
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard_layout, parent, false)
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
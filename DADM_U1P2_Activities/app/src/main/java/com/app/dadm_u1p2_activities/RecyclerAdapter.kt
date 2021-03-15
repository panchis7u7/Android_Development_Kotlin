package com.app.dadm_u1p2_activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter (private var nombresEquiposCasa: List<String>,
                       private var nombresEquiposVisitantes: List<String>,
                       private var imagenesEquiposCasa: List<String>,
                       private var imagenesEquiposVisitante: List<String>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nombreEquipoC: TextView = itemView.findViewById(R.id.act1Team1)
            val nombreEquipoV: TextView = itemView.findViewById(R.id.act1Team2)
            val puntuajeEquipoC: EditText = itemView.findViewById(R.id.act1EditTeam1)
            val puntuajeEquipoV: EditText = itemView.findViewById(R.id.act1EditTeam2)
            val imagenEquipoC: ImageView = itemView.findViewById(R.id.act1ImageTeam1)
            val imagenEquipoV: ImageView = itemView.findViewById(R.id.act1ImageTeam2)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.enfrentamientos_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreEquipoC.text = nombresEquiposCasa[position]
        holder.nombreEquipoV.text = nombresEquiposVisitantes[position]
        Picasso.get().load(imagenesEquiposCasa[position]).into(holder.imagenEquipoC);
        Picasso.get().load(imagenesEquiposVisitante[position]).into(holder.imagenEquipoV);
    }

    override fun getItemCount(): Int {
        return nombresEquiposCasa.size
    }
}
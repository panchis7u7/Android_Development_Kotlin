package com.app.dadm_u1p2_activities

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.app.dadm_u1p2_activities.Models.EditModel
import com.squareup.picasso.Picasso

class RecyclerAdapter(private var ctx: Context,
                     var editModels: MutableList<EditModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    companion object{
        var models: MutableList<EditModel> = arrayListOf()
    }

    init {
        models = editModels
    }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nombreEquipoC: TextView = itemView.findViewById(R.id.act1Team1)
            val nombreEquipoV: TextView = itemView.findViewById(R.id.act1Team2)
            val puntuajeEquipoC: EditText = itemView.findViewById(R.id.act1EditTeam1)
            val puntuajeEquipoV: EditText = itemView.findViewById(R.id.act1EditTeam2)
            val imagenEquipoC: ImageView = itemView.findViewById(R.id.act1ImageTeam1)
            val imagenEquipoV: ImageView = itemView.findViewById(R.id.act1ImageTeam2)

            init {
                puntuajeEquipoC.addTextChangedListener( object: TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        models.get(adapterPosition).setPuntuajeCasa(puntuajeEquipoC.text.toString().toInt())
                    }

                    override fun afterTextChanged(s: Editable?) {
                    }

                })

                puntuajeEquipoV.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        models.get(adapterPosition).setPuntuajeVisitante(puntuajeEquipoV.text.toString().toInt())
                    }

                    override fun afterTextChanged(s: Editable?) {
                    }

                })
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.enfrentamientos_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.nombreEquipoC.text = nombresEquiposCasa[position]
        //holder.nombreEquipoV.text = nombresEquiposVisitantes[position]
        holder.nombreEquipoC.text = models.get(position).getCivilizacionCasa().getNombre()
        holder.nombreEquipoV.text = models.get(position).getCivilizacionVisitante().getNombre()
        Picasso.get().load(models[position].getCivilizacionCasa().getImagen()).into(holder.imagenEquipoC);
        Picasso.get().load(models[position].getCivilizacionVisitante().getImagen()).into(holder.imagenEquipoV);
    }

    override fun getItemCount(): Int {
        return models.size
    }
}
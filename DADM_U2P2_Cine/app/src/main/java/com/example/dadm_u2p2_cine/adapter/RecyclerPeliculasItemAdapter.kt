package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.PeliculaActivity
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.model.Pelicula
import com.example.dadm_u2p2_cine.module.GlideApp
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

class RecyclerPeliculasItemAdapter(val context: Context, val peliculas: List<Pelicula>, val layout: Int):
RecyclerView.Adapter<RecyclerPeliculasItemAdapter.ItemHolder>(){

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ShapeableImageView = itemView.findViewById(R.id.imageViewPelicula)
        val textViewTitulo: TextView = itemView.findViewById(R.id.textViewTitulo)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)



        init {
            itemView.setOnClickListener {
                val position: Int = bindingAdapterPosition
                itemView.context.startActivity(Intent(context, PeliculaActivity::class.java)
                    .putExtra("titulo", "${peliculas.get(position).titulo}"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val pelicula: Pelicula = peliculas.get(position)
        GlideApp.with(holder.itemView)
            .load(pelicula.imagen)
            .dontAnimate()
            .into(holder.imageView)
        holder.imageView.shapeAppearanceModel = holder.imageView.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 20f)
            .build()
        holder.textViewTitulo.text = pelicula.titulo
        holder.ratingBar.rating = pelicula.rating!!
    }

    override fun getItemCount(): Int = peliculas.size

}
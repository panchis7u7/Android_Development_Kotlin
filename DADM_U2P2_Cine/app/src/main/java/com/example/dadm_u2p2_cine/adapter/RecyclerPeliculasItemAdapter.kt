package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.model.Pelicula
import com.example.dadm_u2p2_cine.module.GlideApp
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class RecyclerPeliculasItemAdapter(val context: Context, val peliculas: List<Pelicula>):
RecyclerView.Adapter<RecyclerPeliculasItemAdapter.ItemHolder>(){

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ShapeableImageView = itemView.findViewById(R.id.imageViewPelicula)
        val textViewTitulo: TextView = itemView.findViewById(R.id.textViewTitulo)

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val pelicula: Pelicula = peliculas.get(position)
        Log.d("url", "${pelicula.imagen}------------------------------------------------")
        GlideApp.with(holder.itemView)
            .load(pelicula.imagen)
            .into(holder.imageView)
        holder.textViewTitulo.text = pelicula.titulo
    }

    override fun getItemCount(): Int = peliculas.size

}
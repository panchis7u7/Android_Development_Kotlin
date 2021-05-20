package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.`interface`.IOnItemClick
import com.example.dadm_u2p2_cine.model.Categoria
import com.example.dadm_u2p2_cine.model.Pelicula

open class RecyclerPeliculasAdapter(val context: Context,
                                    val categorias: List<Categoria>,
                                    val orientation: Int,
                                    val layout: Int,
                                    val clickListener: IOnItemClick):
RecyclerView.Adapter<RecyclerPeliculasAdapter.ItemHolder>(){

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerViewItemPeliculas)
        val textViewCategoria: TextView = itemView.findViewById(R.id.textViewCategoria)

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_categoria_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var categoria: Categoria = categorias.get(position)
        holder.textViewCategoria.text = categoria.categoria
        setCallItemsRecycler(holder.recyclerView, categoria.peliculas)
    }

    override fun getItemCount(): Int = categorias.size

    private fun setCallItemsRecycler(recyclerView: RecyclerView, peliculas: List<Pelicula>){
        recyclerView.layoutManager = LinearLayoutManager(context, orientation, false)
        recyclerView.adapter = RecyclerPeliculasItemAdapter(context, peliculas, layout, clickListener)
    }

}
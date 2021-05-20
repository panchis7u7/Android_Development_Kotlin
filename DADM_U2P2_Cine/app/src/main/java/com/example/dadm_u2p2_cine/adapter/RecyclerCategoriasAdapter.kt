package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.google.android.material.button.MaterialButton

open class RecyclerCategoriasAdapter(val context: Context, val categorias: List<String>):
RecyclerView.Adapter<RecyclerCategoriasAdapter.ItemHolder>(){

    inner class ItemHolder(var itemView: View): RecyclerView.ViewHolder(itemView){
        val materialButton: MaterialButton = itemView.findViewById(R.id.materialButtonCategoria)
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_categorias_horizontal_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val categoria: String = categorias.get(position)
        holder.materialButton.text = categoria
    }

    override fun getItemCount(): Int = categorias.size


}
package com.example.contacts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.Contact

class RecyclerContactAdapter(val context: Context, val contactos: List<Contact>):
RecyclerView.Adapter<RecyclerContactAdapter.ItemHolder>(){

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contact_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val contact = contactos.get(position)
    }

    override fun getItemCount(): Int = contactos.size

}
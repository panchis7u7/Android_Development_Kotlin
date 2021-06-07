package com.example.contacts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.Contact
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerContactAdapter(val context: Context, val contactos: List<Contact>):
RecyclerView.Adapter<RecyclerContactAdapter.ItemHolder>(){

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var isOpen: Boolean = false
        val fabOpen = AnimationUtils.loadAnimation(context, R.anim.fab_open_animation)
        val fabClose = AnimationUtils.loadAnimation(context, R.anim.fab_close_animation)
        val textViewName: TextView = itemView.findViewById(R.id.textViewContactName)
        val textViewNumber: TextView = itemView.findViewById(R.id.textViewContactNumber)
        val floatingActionEdit: FloatingActionButton = itemView.findViewById(R.id.floatingActionEdit)
        val floatingActionMessage: FloatingActionButton = itemView.findViewById(R.id.floatingActionMessage)
        val floatingActionMessage1: FloatingActionButton = itemView.findViewById(R.id.floatingAction1)
        val floatingActionMessage2: FloatingActionButton = itemView.findViewById(R.id.floatingAction2)
        val floatingActionMessage3: FloatingActionButton = itemView.findViewById(R.id.floatingAction3)
        val floatingActionMessage4: FloatingActionButton = itemView.findViewById(R.id.floatingAction4)
        val linearLayoutOpciones: LinearLayout = itemView.findViewById(R.id.linearLayoutOpciones)

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contact_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val contact = contactos.get(position)
        holder.textViewName.text = contact.name
        holder.textViewNumber.text = contact.celphone
        holder.floatingActionEdit.setOnClickListener {
            if (holder.isOpen){
                holder.linearLayoutOpciones.visibility = View.GONE
                holder.floatingActionMessage1.startAnimation(holder.fabClose)
                holder.floatingActionMessage2.startAnimation(holder.fabClose)
                holder.floatingActionMessage3.startAnimation(holder.fabClose)
                holder.floatingActionMessage4.startAnimation(holder.fabClose)
                holder.isOpen = false
            } else {
                holder.linearLayoutOpciones.visibility = View.VISIBLE
                holder.floatingActionMessage1.startAnimation(holder.fabOpen)
                holder.floatingActionMessage2.startAnimation(holder.fabOpen)
                holder.floatingActionMessage3.startAnimation(holder.fabOpen)
                holder.floatingActionMessage4.startAnimation(holder.fabOpen)
                holder.isOpen = true
            }

        }
    }

    override fun getItemCount(): Int = contactos.size

}
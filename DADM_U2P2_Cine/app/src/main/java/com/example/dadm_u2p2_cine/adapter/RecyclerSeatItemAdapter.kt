package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R

class RecyclerSeatItemAdapter(val context: Context, val seats: List<AppCompatButton>) :
RecyclerView.Adapter<RecyclerSeatItemAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val buttonSeat: AppCompatButton = itemView.findViewById(R.id.buttonSeat)

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_seat_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val seat: AppCompatButton = seats.get(position)
        seat.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = seats.size

}
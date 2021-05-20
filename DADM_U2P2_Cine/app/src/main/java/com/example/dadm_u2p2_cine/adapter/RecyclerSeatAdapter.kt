package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.model.SeatRow

class RecyclerSeatAdapter(val context: Context, var filas: List<SeatRow>):
RecyclerView.Adapter<RecyclerSeatAdapter.ItemHolder>(){

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val recyclerViewSeatItems: RecyclerView = itemView.findViewById(R.id.recyclerViewSeatItem)
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_seat_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val seat: SeatRow = filas.get(position)
        setCallItemsRecycler(holder.recyclerViewSeatItems, seat.row)
    }

    override fun getItemCount(): Int = filas.size

    private fun setCallItemsRecycler(recyclerView: RecyclerView, seats: List<AppCompatButton>){
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = RecyclerSeatItemAdapter(context, seats)
    }
}
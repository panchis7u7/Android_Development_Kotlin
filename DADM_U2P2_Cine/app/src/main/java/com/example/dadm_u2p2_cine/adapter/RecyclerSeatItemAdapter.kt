package com.example.dadm_u2p2_cine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R


abstract class RecyclerSeatItemAdapter(val context: Context, val seats: List<Int>, val row: Int) :
RecyclerView.Adapter<RecyclerSeatItemAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val buttonSeat: AppCompatButton = itemView.findViewById(R.id.buttonSeat)
        val seatStates = Array(row, {IntArray(7)})

        init {
            itemView.setOnClickListener {
                if(seatStates[row-1][bindingAdapterPosition] == 0) {
                    it.background.setTint(context.getColor(R.color.category))
                    selectedSeats(row, bindingAdapterPosition, seatStates)
                    seatStates[row-1][bindingAdapterPosition] = 1
                } else {
                    it.background.setTint(context.getColor(R.color.buttonCategory))
                    selectedSeats(row, bindingAdapterPosition, seatStates)
                    seatStates[row - 1][bindingAdapterPosition] = 0
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_seat_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = seats.size

    abstract fun selectedSeats(row: Int, seat: Int, seatStates: Array<IntArray>)
}
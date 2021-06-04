package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TableLayout
import android.widget.TextView
import androidx.core.app.DialogCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerAdapterAvanceMaterias (private val context: Context,
                                     private val materias: List<Materia>,
                                     private val seleccion: Boolean) :
RecyclerView.Adapter<RecyclerAdapterAvanceMaterias.ItemHolder>(){

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewClave: TextView = itemView.findViewById(R.id.textViewClave)
        val textViewMateria: TextView = itemView.findViewById(R.id.textViewMateria)
        val textViewCalificacion: TextView = itemView.findViewById(R.id.textViewCalificacion)
        val textViewRegularizacion: TextView = itemView.findViewById(R.id.textViewRegularizacion)
        val cardViewAvance: MaterialCardView = itemView.findViewById(R.id.cardViewAvance)
        val buttonSeleccionar: MaterialButton = itemView.findViewById(R.id.buttonSeleccionar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_avance_layout, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var materia: Materia = materias.get(position)
        holder.textViewClave.text = materia.clave
        holder.textViewMateria.text = materia.materia
        holder.textViewCalificacion.text = materia.calificacion
        holder.textViewRegularizacion.text = materia.regularizacion

        if(holder.textViewCalificacion.text == "" && materia.profesor!!.isNotEmpty()) {
            holder.cardViewAvance.setCardBackgroundColor(context.resources.getColor(R.color.cursandoMateria))
            holder.textViewCalificacion.text = "Cursando"
        } else if (holder.textViewCalificacion.text == "") {
            holder.cardViewAvance.setCardBackgroundColor(context.resources.getColor(R.color.colorNoCursado))
            holder.textViewCalificacion.text = "No Cursada"
            if(seleccion) holder.buttonSeleccionar.visibility = View.VISIBLE else View.GONE

            holder.buttonSeleccionar.setOnClickListener {
                handleSelection(materia, holder)
            }
        }
    }

    override fun getItemCount(): Int = materias.size

    fun handleSelection(materia: Materia, holder: ItemHolder) {
        val view = LayoutInflater.from(context).inflate(R.layout.grupos_dialog_layout, null)
        val tableLayout: TableLayout = view.findViewById(R.id.tableLayoutGrupos)
        //val alertDialog = AlertDialog.Builder(context).setView(view).setTitle("Cali").show()
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        popupWindow.width = 1000
        popupWindow.height = 1200
        popupWindow.showAtLocation(view , Gravity.CENTER, 0, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            popupWindow.elevation = 30.0F
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val slideIn = Slide()
            slideIn.slideEdge = Gravity.TOP
            popupWindow.enterTransition = slideIn

            val slideOut = Slide()
            slideOut.slideEdge = Gravity.BOTTOM
            popupWindow.exitTransition = slideOut
        }

        view.findViewById<FloatingActionButton>(R.id.fabCloseSelection).setOnClickListener {
            popupWindow.dismiss()
        }
        //tableLayout.addView(holder.textViewClave)
    }
}
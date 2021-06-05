package com.example.dadm_u1p4_aplicacion_escolar.Adapters

import android.content.Context
import android.os.Build
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.TableLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Interfaces.IOnClickSelection
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class RecyclerAdapterAvanceMaterias(
    private val context: Context,
    private val materias: List<Materia>,
    private val seleccion: Boolean,
    private val onCLick: IOnClickSelection?,
) :
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
        val materia: Materia = materias.get(position)
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
        val textViewClave: TextView = view.findViewById(R.id.textViewClave)
        val textViewMateria: TextView = view.findViewById(R.id.textViewMateria)

        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){ popupWindow.elevation = 30.0F }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val slideIn = Slide()
            slideIn.slideEdge = Gravity.TOP
            popupWindow.enterTransition = slideIn

            val slideOut = Slide()
            slideOut.slideEdge = Gravity.BOTTOM
            popupWindow.exitTransition = slideOut
        }

        popupWindow.showAtLocation(view , Gravity.CENTER, 0, 0);

        view.findViewById<FloatingActionButton>(R.id.fabCloseSelection).setOnClickListener {
            popupWindow.dismiss()
        }

        val document = Firebase.firestore.collection("carreras/ITICs/reinscripcion")
            .whereEqualTo("clave", materia.clave)
            .orderBy("grupo", Query.Direction.ASCENDING)
        GlobalScope.launch(Dispatchers.IO) {
            val materiaDocs = document.get().await()
            val materias = mutableListOf<Materia>()
            var index = 0
            materiaDocs.documents.forEach { document ->
                index++
                materias.add(Materia(
                    clave = (document.get("clave") as String),
                    grupo = (document.get("grupo") as String),
                    materia = (document.get("materia") as String),
                    profesor = (document.get("profesor") as String),
                    horarios = (document.get("horarios") as List<String>),
                    aulas =  (document.get("aulas") as List<String>)
                ))

                withContext(Dispatchers.Main) {
                    textViewClave.text = materia.clave
                    textViewMateria.text = materia.materia
                    val row = TableRow(context)
                    val tableRowParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT)
                    tableRowParams.setMargins(0, 0, 0, 0)
                    row.setPadding(0, 0, 0, 0)
                    row.layoutParams = tableRowParams

                    val textViewGrupo = TextView(context)
                    textViewGrupo.setPadding(5, 10, 0, 10)
                    textViewGrupo.text = materias[index-1].grupo
                    textViewGrupo.setTextColor(context.resources.getColor(R.color.black))
                    row.addView(textViewGrupo)

                    val textViewParams = TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT)
                    textViewParams.setMargins(0, 5,15,5)

                    for (i in 0 .. 4) {
                        val textViewHorarios = TextView(context)
                        textViewHorarios.setPadding(5, 10, 0, 10)
                        textViewHorarios.layoutParams = textViewParams
                        textViewHorarios.text = materias[index-1].horarios?.get(i) + "/" + materias[index-1].aulas?.get(i)
                        textViewHorarios.setTextColor(context.resources.getColor(R.color.black))
                        row.addView(textViewHorarios)
                    }

                    val buttonParams = TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        100)

                    val materialButton = MaterialButton(context)
                    materialButton.text = "Seleccionar"
                    materialButton.setBackgroundColor(context.resources.getColor(R.color.red))
                    materialButton.setTextColor(context.resources.getColor(R.color.white))
                    materialButton.isAllCaps = false
                    materialButton.setPadding(5,0,5,0)
                    materialButton.layoutParams = buttonParams
                    materialButton.textSize = 12f
                    row.addView(materialButton)
                    tableLayout.addView(row)

                    materialButton.setOnClickListener {
                        val rowSelected = it.getParent() as TableRow
                        onCLick?.onSelectionClick(materia, rowSelected)
                    }

                }
            }
        }
    }
}
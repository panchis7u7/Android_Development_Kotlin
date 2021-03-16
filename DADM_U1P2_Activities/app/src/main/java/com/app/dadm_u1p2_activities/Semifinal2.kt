package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_semifinal2.*

class Semifinal2 : AppCompatActivity() {

    private var modelos = mutableListOf<EditModel>()
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semifinal2)

        adapter = RecyclerAdapter(this, RecyclerAdapter.models)
        modelos = populateList()

        RecyclerAdapter.models = modelos
        mainRecyclerViewSemi.layoutManager = LinearLayoutManager(this)
        mainRecyclerViewSemi.adapter = RecyclerAdapter(this, modelos)

        btnSigS2.setOnClickListener{
            for(i in 0 .. RecyclerAdapter.models.size-1){
                Log.d("$i: ", adapter.editModels.get(i).getCivilizacionCasa().getNombre() +
                        adapter.editModels.get(i).getPuntuajeCasa() +
                        adapter.editModels.get(i).getCivilizacionVisitante().getNombre() +
                        adapter.editModels.get(i).getPuntuajeVisitante())
            }
            val intent = Intent(this, FinalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getStaticModels(): MutableList<EditModel>{
        return RecyclerAdapter.models
    }

    private fun populateList(): MutableList<EditModel>{
        var duelos: MutableList<EditModel> = arrayListOf()
        var civilizaciones: MutableList<Civilizacion> = arrayListOf()
        for(i in 0 .. adapter.editModels.size-1){
            var duelo: EditModel = adapter.editModels.get(i)
            if(duelo.getPuntuajeCasa() > duelo.getPuntuajeVisitante())
                civilizaciones.add(duelo.getCivilizacionCasa())
            else
                civilizaciones.add(duelo.getCivilizacionVisitante())
        }

        for(j in 0 .. civilizaciones.size-1 step 2){
            duelos.add(EditModel(civilizaciones[j], civilizaciones[j+1]))
        }

        return duelos
    }
}
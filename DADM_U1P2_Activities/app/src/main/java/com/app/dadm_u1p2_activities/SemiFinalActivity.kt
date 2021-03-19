package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel
import com.app.dadm_u1p2_activities.databinding.ActivitySemifinalBinding

class SemiFinalActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySemifinalBinding
    private lateinit var adapter: RecyclerAdapter
    private var modelos = mutableListOf<EditModel>()
    private var empate: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_semifinal)
        binding = ActivitySemifinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modelos = RecyclerAdapter.models
        adapter = RecyclerAdapter(this, modelos)

        binding.mainRecyclerViewSemi.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerViewSemi.adapter = adapter

        binding.btnSigS2.setOnClickListener{
            RecyclerAdapter.models = getWinners()
            if(!empate) {
                for (i in 0..RecyclerAdapter.models.size - 1) {
                    Log.d("$i: ",
                            adapter.editModels.get(i).getCivilizacionCasa().getNombre() +
                                    adapter.editModels.get(i).getPuntuajeCasa() +
                                    adapter.editModels.get(i).getCivilizacionVisitante().getNombre() +
                                    adapter.editModels.get(i).getPuntuajeVisitante())
                }
                val intent = Intent(this, FinalActivity::class.java)
                var bundle = Bundle()
                bundle.putString("Equipo1", RecyclerAdapter.models.get(0).getCivilizacionCasa().getNombre())
                bundle.putString("Equipo1Imagen", RecyclerAdapter.models.get(0).getCivilizacionCasa().getImagen())
                bundle.putString("Equipo2", RecyclerAdapter.models.get(0).getCivilizacionVisitante().getNombre())
                bundle.putString("Equipo2Imagen", RecyclerAdapter.models.get(0).getCivilizacionVisitante().getImagen())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun getWinners(): MutableList<EditModel>{
        var duelos: MutableList<EditModel> = arrayListOf()
        var civilizaciones: MutableList<Civilizacion> = arrayListOf()
        for(i in 0 .. adapter.editModels.size-1){
            var duelo: EditModel = adapter.editModels.get(i)
            if(duelo.getPuntuajeCasa() > duelo.getPuntuajeVisitante()) {
                this.empate = false
                civilizaciones.add(duelo.getCivilizacionCasa())
            } else if(duelo.getPuntuajeCasa() < duelo.getPuntuajeVisitante()) {
                this.empate = false
                civilizaciones.add(duelo.getCivilizacionVisitante())
            } else {
                this.empate = true
                Toast.makeText(this, getString(R.string.tieToast), Toast.LENGTH_LONG).show()
                return arrayListOf()
            }
        }

        for(j in 0 .. civilizaciones.size-1 step 2){
            duelos.add(EditModel(civilizaciones[j], civilizaciones[j+1]))
        }

        return duelos
    }

}
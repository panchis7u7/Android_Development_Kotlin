package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel
import com.app.dadm_u1p2_activities.Models.WinnerActivity
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.android.synthetic.main.activity_semifinal2.*

class FinalActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        adapter = RecyclerAdapter(this, RecyclerAdapter.models)
        var ganador: Civilizacion =  populateList()

        mainRecyclerViewFinal.layoutManager = LinearLayoutManager(this)
        mainRecyclerViewFinal.adapter = RecyclerAdapter(this, RecyclerAdapter.models)

        btnSigS3.setOnClickListener{
            Log.d("Ganador: ", ganador.getNombre())
            val intent = Intent(this, WinnerActivity::class.java)
            var bundle = Bundle()
            bundle.putString("ganador", ganador.getNombre())
            bundle.putString("imagenGanador", ganador.getImagen())
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun populateList(): Civilizacion{
        var ganador = Civilizacion()
        for(i in 0 .. adapter.editModels.size-1){
            var duelo: EditModel = adapter.editModels.get(i)
            if(duelo.getPuntuajeCasa() > duelo.getPuntuajeVisitante())
                ganador = duelo.getCivilizacionCasa()
            else
                ganador = duelo.getCivilizacionVisitante()
        }

        return ganador
    }
}
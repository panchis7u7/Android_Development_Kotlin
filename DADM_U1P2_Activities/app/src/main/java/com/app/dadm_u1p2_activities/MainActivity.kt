package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private var modelos = mutableListOf<EditModel>()
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecyclerAdapter(this, RecyclerAdapter.models)
        modelos = populateList()

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = RecyclerAdapter(this, modelos)
        btnSigS1.setOnClickListener{
            RecyclerAdapter.models = getWinners()
            for(i in 0 .. adapter.editModels.size-1){
                Log.d("$i: ", adapter.editModels.get(i).getCivilizacionCasa().getNombre() +
                        adapter.editModels.get(i).getPuntuajeCasa() +
                        adapter.editModels.get(i).getCivilizacionVisitante().getNombre() +
                        adapter.editModels.get(i).getPuntuajeVisitante())
            }
            val intent = Intent(this, Semifinal2::class.java)
            startActivity(intent)
        }
    }

    private fun getWinners(): MutableList<EditModel>{
        var duelos: MutableList<EditModel> = arrayListOf()
        var civilizaciones: MutableList<Civilizacion> = arrayListOf()
        for(i in 0 .. RecyclerAdapter.models.size-1){
            var duelo: EditModel = RecyclerAdapter.models.get(i)
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

    private fun populateList(): MutableList<EditModel>{
        var modelos: MutableList<EditModel> = arrayListOf()

        modelos.add(EditModel(Civilizacion("Persas", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Achaemenid_Falcon.svg/220px-Achaemenid_Falcon.svg.png"),
                    Civilizacion("Vikingos", "https://i.pinimg.com/originals/6f/7b/e5/6f7be576c51c4070dd20d51aa7751b52.png")))

        modelos.add(EditModel(Civilizacion("Teutones", "https://static.wikia.nocookie.net/theassassinscreed/images/1/12/Teut%C3%B3nicos.png/revision/latest/scale-to-width-down/600?cb=20160207152744&path-prefix=es"),
                Civilizacion("Aztecas", "https://dbdzm869oupei.cloudfront.net/img/sticker/preview/12305.png")))

        modelos.add(EditModel(Civilizacion("Japoneses", "https://i.pinimg.com/originals/91/3c/f2/913cf2a19bf069f8df2ef9096f14b355.png"),
                Civilizacion("Sarracenos", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Cross_of_Saint_James.svg/1200px-Cross_of_Saint_James.svg.png")))

        modelos.add(EditModel(Civilizacion("Españoles", "https://i.pinimg.com/originals/c3/12/d8/c312d830c69d8e795045a2e7cc43d025.png"),
                Civilizacion("Vietnamitas", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Rounded_symbol_for_shuangxi-U-1F264.svg/1200px-Rounded_symbol_for_shuangxi-U-1F264.svg.png")))
        return modelos
    }
}
package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        var casa = Civilizacion(intent.getStringExtra("Equipo1").toString(),
            intent.getStringExtra("Equipo1Imagen").toString())
        var visitante = Civilizacion(intent.getStringExtra("Equipo2").toString(),
            intent.getStringExtra("Equipo2Imagen").toString())

        act3Team1.text = casa.getNombre()
        act3Team2.text = visitante.getNombre()
        Picasso.get().load(casa.getImagen()).into(act3ImageTeam1);
        Picasso.get().load(visitante.getImagen()).into(act3ImageTeam2);

        btnSigS3.setOnClickListener{
            var ganador: Civilizacion =  obtenerGanador(EditModel(casa, visitante))
            Log.d("Ganador: ", ganador.getNombre())
            val intent = Intent(this, WinnerActivity::class.java)
            var bundle = Bundle()
            bundle.putString("ganador", ganador.getNombre())
            bundle.putString("imagenGanador", ganador.getImagen())
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun obtenerGanador(duelo: EditModel): Civilizacion{
        var ganador = Civilizacion()
        if(act3EditTeam1.text.toString().toInt() > act3EditTeam2.text.toString().toInt())
            return duelo.getCivilizacionCasa()
        else
            return duelo.getCivilizacionVisitante()
    }
}
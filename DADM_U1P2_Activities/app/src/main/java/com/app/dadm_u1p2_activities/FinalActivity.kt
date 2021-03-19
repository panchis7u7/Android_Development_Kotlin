package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel
import com.app.dadm_u1p2_activities.databinding.ActivityFinalBinding
import com.squareup.picasso.Picasso

class FinalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalBinding
    private var empate: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_final)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var casa = Civilizacion(intent.getStringExtra("Equipo1").toString(),
            intent.getStringExtra("Equipo1Imagen").toString())
        var visitante = Civilizacion(intent.getStringExtra("Equipo2").toString(),
            intent.getStringExtra("Equipo2Imagen").toString())

        binding.act3Team1.text = casa.getNombre()
        binding.act3Team2.text = visitante.getNombre()
        Picasso.get().load(casa.getImagen()).into(binding.act3ImageTeam1);
        Picasso.get().load(visitante.getImagen()).into(binding.act3ImageTeam2);

        binding.btnSigS3.setOnClickListener{
            var ganador: Civilizacion =  obtenerGanador(EditModel(casa, visitante))
            if(!empate) {
                Log.d("Ganador: ", ganador.getNombre())
                val intent = Intent(this, WinnerActivity::class.java)
                var bundle = Bundle()
                bundle.putString("ganador", ganador.getNombre())
                bundle.putString("imagenGanador", ganador.getImagen())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun obtenerGanador(duelo: EditModel): Civilizacion{
        var ganador = Civilizacion()
        if(binding.act3EditTeam1.text.toString().toInt() > binding.act3EditTeam2.text.toString().toInt()) {
            this.empate = false
            return duelo.getCivilizacionCasa()
        } else if(binding.act3EditTeam1.text.toString().toInt() < binding.act3EditTeam2.text.toString().toInt()) {
            this.empate = false
            return duelo.getCivilizacionVisitante()
        } else {
            this.empate = true
            Toast.makeText(this, getString(R.string.tieToast), Toast.LENGTH_LONG).show()
            return Civilizacion()
        }
    }
}
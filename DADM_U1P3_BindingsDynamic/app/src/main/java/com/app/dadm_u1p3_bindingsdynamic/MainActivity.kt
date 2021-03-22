package com.app.dadm_u1p3_bindingsdynamic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.app.dadm_u1p3_bindingsdynamic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
AdapterView.OnItemClickListener{

    private lateinit var binding: ActivityMainBinding
    private var pelicula = ""
    private var horario = ""
    private var sala =""
    private var nBoletos = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //------------------------------------------------------------------------------------------
        // Manejadores de eventos a traves de funciones anonimas.

        val boletos = ArrayList<String>()
        for(i in 1..10)
            boletos.add("$i")
        binding.spinnerNumBoletos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
        boletos)
        binding.spinnerNumBoletos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                view?.let {
                    val textView = findViewById<TextView>(android.R.id.text1)
                    nBoletos = textView.text.toString()
                    actualizaSeleccion()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val salas: Array<String> = arrayOf("Normal", "4DX")
        binding.listViewSala.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, salas)
        binding.listViewSala.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                view?.let {
                    sala = salas[position]
                    actualizaSeleccion()
                }
            }
        }

        binding.btnComprar.setOnClickListener{
            val intent = Intent(this, CompraActivity::class.java)
            val datos = arrayOf(pelicula, sala, horario, nBoletos)
            intent.putExtra("datos", datos)
            startActivity(intent)
        }

        //------------------------------------------------------------------------------------------
        // Manejadores de eventos a traves de herencia.

        binding.listViewPeliculas.onItemClickListener = this
        binding.spinnerHorarios.onItemSelectedListener = this

        //------------------------------------------------------------------------------------------

    }

    private fun actualizaSeleccion() {
        binding.textSeleccion.text = """Tu selección:
           Película: $pelicula
           Sala: $sala
           Horario: $horario
           Boletos: $nBoletos
        """.trimIndent()
    }

    //----------------------------------------------------------------------------------------------
    // listViewPeliculas events.

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        view?.let {
            val textView = it as TextView
            pelicula = "" + textView.text
            actualizaSeleccion()
        }
    }

    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    // spinnerHorarios events.

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    //----------------------------------------------------------------------------------------------
}
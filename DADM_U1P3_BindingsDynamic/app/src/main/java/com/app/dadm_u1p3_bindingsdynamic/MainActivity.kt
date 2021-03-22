package com.app.dadm_u1p3_bindingsdynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.dadm_u1p3_bindingsdynamic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

        val salas
    }
}
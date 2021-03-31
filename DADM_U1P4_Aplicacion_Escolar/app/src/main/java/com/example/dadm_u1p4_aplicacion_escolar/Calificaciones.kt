package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityCalificacionesBinding

class Calificaciones : AppCompatActivity() {

    private lateinit var binding: ActivityCalificacionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_calificaciones)
        binding = ActivityCalificacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun populateList(){

    }
}
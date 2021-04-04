package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityHorariosBinding

class Horarios : AppCompatActivity() {
    private lateinit var binding: ActivityHorariosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorariosBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_horarios)
        setContentView(binding.root)
    }
}
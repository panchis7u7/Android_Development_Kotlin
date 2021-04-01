package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityAvanceCurricularBinding

class AvanceCurricular : AppCompatActivity() {
    private lateinit var binding: ActivityAvanceCurricularBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvanceCurricularBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_avance_curricular)
        setContentView(binding.root)
    }
}
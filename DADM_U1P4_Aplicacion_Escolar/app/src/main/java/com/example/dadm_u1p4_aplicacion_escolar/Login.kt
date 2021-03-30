package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityLoginBinding
import com.squareup.picasso.Picasso

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)
    }
}
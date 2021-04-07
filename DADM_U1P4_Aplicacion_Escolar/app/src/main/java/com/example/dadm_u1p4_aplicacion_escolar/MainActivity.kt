package com.example.dadm_u1p4_aplicacion_escolar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread.sleep(4000)

        auth = FirebaseAuth.getInstance()

        if(auth.currentUser == null)
            startActivity(Intent(this, Login::class.java))
        else
            startActivity(Intent(this, Dashboard::class.java))

    }
}
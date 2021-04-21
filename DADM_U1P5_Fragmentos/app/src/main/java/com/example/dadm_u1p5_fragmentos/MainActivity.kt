package com.example.dadm_u1p5_fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p5_fragmentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }
}
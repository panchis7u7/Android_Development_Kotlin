package com.example.dadm_u1p5_fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.dadm_u1p5_fragmentos.databinding.ActivityMainBinding
import com.example.dadm_u1p5_fragmentos.fragments.ActivityFragment
import com.example.dadm_u1p5_fragmentos.viewmodels.ActivityFragmentViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ActivityFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val fragmento = supportFragmentManager.findFragmentById(R.id.mainFragmento) as ActivityFragment

        binding.buttonEnviar.setOnClickListener {
            binding.editTextMensaje.text.let {
                viewModel.setText(it.toString())
            }
        }
    }
}
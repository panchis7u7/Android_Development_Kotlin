package com.example.dadm_u2p2_cine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u2p2_cine.databinding.ActivityPeliculaBinding

class PeliculaActivity : AppCompatActivity() {
    private var _binding: ActivityPeliculaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPeliculaBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_pelicula)
        setContentView(binding!!.root)

        var titulo: String? = ""
        intent?.let {
            titulo = it.extras?.getString("titulo")
        }

        binding.textViewTitulo.text = titulo

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
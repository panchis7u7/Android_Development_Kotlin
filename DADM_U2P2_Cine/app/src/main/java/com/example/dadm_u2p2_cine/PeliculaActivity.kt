package com.example.dadm_u2p2_cine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u2p2_cine.databinding.ActivityPeliculaBinding
import com.example.dadm_u2p2_cine.model.Pelicula
import com.example.dadm_u2p2_cine.module.GlideApp

class PeliculaActivity : AppCompatActivity() {
    private var _binding: ActivityPeliculaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPeliculaBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_pelicula)
        setContentView(binding!!.root)

        var pelicula: Pelicula? = Pelicula()
        intent?.let {
            pelicula = it.extras?.getParcelable<Pelicula>("pelicula")
        }

        binding.textViewTitulo.text = pelicula?.titulo
        GlideApp.with(this)
            .load(pelicula?.cover)
            .dontAnimate()
            .into(binding.imageViewCover)
        binding.ratingBarPelicula.rating = pelicula?.rating!!
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
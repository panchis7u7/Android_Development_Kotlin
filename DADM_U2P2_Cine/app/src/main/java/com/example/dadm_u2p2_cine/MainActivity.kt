package com.example.dadm_u2p2_cine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.adapter.RecyclerPeliculasAdapter
import com.example.dadm_u2p2_cine.adapter.RecyclerPeliculasItemAdapter
import com.example.dadm_u2p2_cine.databinding.ActivityMainBinding
import com.example.dadm_u2p2_cine.fragment.HomeFragment
import com.example.dadm_u2p2_cine.model.Categoria
import com.example.dadm_u2p2_cine.model.Pelicula

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        supportFragmentManager.findFragmentById(R.id.fragmentHome) as HomeFragment

        binding.bottomNavigationView.background = null
        binding.bottomAppBar.background = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
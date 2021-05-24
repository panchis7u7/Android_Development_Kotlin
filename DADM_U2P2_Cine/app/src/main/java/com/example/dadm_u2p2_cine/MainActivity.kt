package com.example.dadm_u2p2_cine

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        supportActionBar?.let {
            it.title = "Cinepolis V2"
            it.setDefaultDisplayHomeAsUpEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        navController = findNavController(R.id.fragmentHome)
        setupActionBarWithNavController(navController, AppBarConfiguration(setOf(
            R.id.homeFragment, R.id.profileFragment
        )))

        binding.bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavigationView.background = null
        binding.bottomAppBar.background = null

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navHome -> {navController.navigate(R.id.homeFragment)
                                return@setOnNavigationItemSelectedListener true}
                R.id.navProfile -> {navController.navigate(R.id.profileFragment)
                                return@setOnNavigationItemSelectedListener true}
                else -> {return@setOnNavigationItemSelectedListener false}
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        super.navigateUpTo(upIntent)
        onBackPressed()
        return true
    }
}
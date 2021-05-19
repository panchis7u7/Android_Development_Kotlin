package com.example.dadm_u2p2_cine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.adapter.RecyclerPeliculasItemAdapter
import com.example.dadm_u2p2_cine.databinding.ActivityMainBinding
import com.example.dadm_u2p2_cine.model.Pelicula

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.recyclerViewPeliculas.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.recyclerViewPeliculas.adapter = RecyclerPeliculasItemAdapter(this, populateList())
    }

    private fun populateList(): MutableList<Pelicula>{
        var peliculas: MutableList<Pelicula> = mutableListOf()
        peliculas.add(Pelicula("Godzilla vs Kong", "https://m.media-amazon.com/images/M/MV5BZmYzMzU4NjctNDI0Mi00MGExLWI3ZDQtYzQzYThmYzc2ZmNjXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg"))
        peliculas.add(Pelicula("John Wick 3", "https://upload.wikimedia.org/wikipedia/en/thumb/9/94/John_Wick_Chapter_3_Parabellum.png/220px-John_Wick_Chapter_3_Parabellum.png"))
        peliculas.add(Pelicula("a", "https://thumbs.dreamstime.com/b/environment-earth-day-hands-trees-growing-seedlings-bokeh-green-background-female-hand-holding-tree-nature-field-gra-130247647.jpg"))
        return peliculas
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
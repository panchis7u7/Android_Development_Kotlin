package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.`interface`.IMovieClick
import com.example.dadm_u2p2_cine.adapter.RecyclerCategoriasAdapter
import com.example.dadm_u2p2_cine.adapter.RecyclerPeliculasAdapter
import com.example.dadm_u2p2_cine.databinding.FragmentHomeBinding
import com.example.dadm_u2p2_cine.model.Categoria
import com.example.dadm_u2p2_cine.model.DBManager
import com.example.dadm_u2p2_cine.model.Pelicula
import com.example.dadm_u2p2_cine.stateflow.MovieStateFlow

class HomeFragment: Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val stateFlow: MovieStateFlow by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        val db = DBManager(requireContext(), "cine", null, 1)

        binding.recyclerViewCategorias.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.recyclerViewCategorias.adapter = object : RecyclerCategoriasAdapter(requireContext(), populateCategorias()){
            override fun onButtonSelected(content: String) {

            }

        }

        val categorias: MutableList<Categoria> = mutableListOf()

        try {
            categorias.add(Categoria("Popular", db.getPeliculas()))
            //db.deleteDatabase(requireContext(), "cine")
        } catch (e: Exception){
            e.printStackTrace()
        }

        binding.recyclerViewPeliculas.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerViewPeliculas.adapter = RecyclerPeliculasAdapter(
            requireContext(), categorias, RecyclerView.HORIZONTAL, R.layout.item_pelicula_horizontal_layout,
            object : IMovieClick {
                override fun onItemClick(pelicula: Pelicula) {
                    stateFlow.setMovie(pelicula)
                    findNavController().navigate(R.id.action_homeFragment_to_peliculaFragment)
                }
            })

        binding.recyclerViewRecommended.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerViewRecommended.adapter = RecyclerPeliculasAdapter(
            requireContext(), categorias, RecyclerView.VERTICAL, R.layout.item_pelicula_vertical_layout,
            object : IMovieClick {
                override fun onItemClick(pelicula: Pelicula) {
                    stateFlow.setMovie(pelicula)
                    findNavController().navigate(R.id.action_homeFragment_to_peliculaFragment)
                }
            })

        return  binding.root
    }

    private fun populateCategorias(): MutableList<String>{
        var categorias: MutableList<String> = mutableListOf()

        categorias.add(String(Character.toChars(0x1F60E)) + " Accion")
        categorias.add(String(Character.toChars(0x1F920)) + " Aventura")
        categorias.add(String(Character.toChars(0x263A)) + " Drama")
        return categorias
    }
}
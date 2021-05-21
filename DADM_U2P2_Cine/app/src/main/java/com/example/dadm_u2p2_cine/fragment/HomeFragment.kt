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

        binding.recyclerViewCategorias.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.recyclerViewCategorias.adapter = object : RecyclerCategoriasAdapter(requireContext(), populateCategorias()){
            override fun onButtonSelected(content: String) {

            }

        }

        binding.recyclerViewPeliculas.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerViewPeliculas.adapter = RecyclerPeliculasAdapter(
            requireContext(), populateList(), RecyclerView.HORIZONTAL, R.layout.item_pelicula_horizontal_layout,
            object : IMovieClick {
                override fun onItemClick(pelicula: Pelicula) {
                    stateFlow.setMovie(pelicula)
                    findNavController().navigate(R.id.action_homeFragment_to_peliculaFragment)
                }
            })

        binding.recyclerViewRecommended.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerViewRecommended.adapter = RecyclerPeliculasAdapter(
            requireContext(), populateList(), RecyclerView.VERTICAL, R.layout.item_pelicula_vertical_layout,
            object : IMovieClick {
                override fun onItemClick(pelicula: Pelicula) {
                    stateFlow.setMovie(pelicula)
                    findNavController().navigate(R.id.action_homeFragment_to_peliculaFragment)
                }
            })

        return  binding.root
    }

    private fun populateList(): MutableList<Categoria>{
        var peliculas: MutableList<Pelicula> = mutableListOf()
        peliculas.add(Pelicula("Godzilla vs Kong",
            "https://m.media-amazon.com/images/M/MV5BZmYzMzU4NjctNDI0Mi00MGExLWI3ZDQtYzQzYThmYzc2ZmNjXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg",
            "https://i.blogs.es/3a35be/godzilla-kong/1366_2000.jpeg",3f))
        peliculas.add(Pelicula("John Wick 3",
            "https://upload.wikimedia.org/wikipedia/en/thumb/9/94/John_Wick_Chapter_3_Parabellum.png/220px-John_Wick_Chapter_3_Parabellum.png",
            "https://cinergiaonline.com/wp-content/uploads/2019/05/John-Wick-3-Parabellum.jpg",2.5f))
        peliculas.add(Pelicula("Avenges: Endgame",
            "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/9b/Avenger_Endgame_Poster_Oficial.png/revision/latest/scale-to-width-down/1000?cb=20190326185910&path-prefix=es",
            "https://i0.wp.com/hipertextual.com/wp-content/uploads/2019/04/hipertextual-mejores-trailers-semana-avengers-endgame-rey-leon-godzilla-2-2019907932.jpg?fit=1600%2C900&ssl=1",4f))
        peliculas.add(Pelicula("Spiderman 3",
            "https://static.wikia.nocookie.net/spiderman/images/2/2c/Spider-Man_3_Poster.png/revision/latest?cb=20200612203333&path-prefix=es",
            "https://pbs.twimg.com/media/E0zwjEAXEAE71G2.jpg",4.5f))

        var categorias: MutableList<Categoria> = mutableListOf()
        categorias.add(Categoria("Popular", peliculas))
        return categorias
    }

    private fun populateCategorias(): MutableList<String>{
        var categorias: MutableList<String> = mutableListOf()

        categorias.add(String(Character.toChars(0x1F60E)) + " Accion")
        categorias.add(String(Character.toChars(0x1F920)) + " Aventura")
        categorias.add(String(Character.toChars(0x263A)) + " Drama")
        return categorias
    }
}
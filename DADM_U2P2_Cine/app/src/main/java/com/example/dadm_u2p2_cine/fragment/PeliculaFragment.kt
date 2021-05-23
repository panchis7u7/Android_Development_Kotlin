package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.databinding.FragmentPeliculaBinding
import com.example.dadm_u2p2_cine.model.Pelicula
import com.example.dadm_u2p2_cine.module.GlideApp
import com.example.dadm_u2p2_cine.stateflow.MovieStateFlow
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.flow.collect

class PeliculaFragment: Fragment(R.layout.fragment_pelicula) {
    private var _binding: FragmentPeliculaBinding? = null
    private val binding get() = _binding!!
    private val stateFlow: MovieStateFlow by activityViewModels()
    private var id: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPeliculaBinding.inflate(layoutInflater)

        lifecycleScope.launchWhenStarted {
            stateFlow.movieState.collect {
                when(it){
                    is MovieStateFlow.LatestMovieState.Success -> {
                        id = it.movie.id_pelicula
                        binding.textViewTitulo.text = it.movie.titulo
                        GlideApp.with(requireContext())
                            .load(it.movie.cover)
                            .dontAnimate()
                            .into(binding.imageViewCover)
                        binding.textViewTitulo.text = it.movie.titulo
                        binding.textViewDirector.text = "Director: ${it.movie.director}"
                        binding.materialButtonCategoria.text = it.movie.genero
                        binding.ratingBarPelicula.rating = it.movie?.rating!!
                        binding.textViewSinopsis.text = it.movie.sinopsis
                    }
                }
            }
        }

        binding.buttonReservar.setOnClickListener {
            val bundle = bundleOf("id" to id)
            findNavController().navigate(R.id.action_peliculaFragment_to_selectionFragment, bundle)
        }

        return binding.root
    }
}
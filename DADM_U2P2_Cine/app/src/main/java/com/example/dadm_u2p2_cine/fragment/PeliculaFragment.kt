package com.example.dadm_u2p2_cine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.dadm_u2p2_cine.R
import com.example.dadm_u2p2_cine.databinding.FragmentPeliculaBinding
import com.example.dadm_u2p2_cine.module.GlideApp
import com.example.dadm_u2p2_cine.stateflow.MovieStateFlow
import kotlinx.coroutines.flow.collect

class PeliculaFragment: Fragment(R.layout.fragment_pelicula) {
    private var _binding: FragmentPeliculaBinding? = null
    private val binding get() = _binding!!
    private val stateFlow: MovieStateFlow by activityViewModels()

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
                        binding.textViewTitulo.text = it.movie.titulo
                        GlideApp.with(requireContext())
                            .load(it.movie.cover)
                            .dontAnimate()
                            .into(binding.imageViewCover)
                        binding.ratingBarPelicula.rating = it.movie?.rating!!
                    }
                }
            }
        }

        binding.buttonReservar.setOnClickListener {
            findNavController().navigate(R.id.action_peliculaFragment_to_selectionFragment)
        }

        return binding.root
    }
}
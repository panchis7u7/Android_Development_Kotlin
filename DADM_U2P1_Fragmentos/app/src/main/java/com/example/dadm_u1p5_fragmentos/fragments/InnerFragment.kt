package com.example.dadm_u1p5_fragmentos.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.dadm_u1p5_fragmentos.databinding.FragmentInnerBinding
import com.example.dadm_u1p5_fragmentos.viewmodels.FragmentActivityMensajeViewModel

class InnerFragment: Fragment() {
    private var _binding: FragmentInnerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FragmentActivityMensajeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentInnerBinding.inflate(layoutInflater)

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Oyente o manejador de evento que se dispara cuando el fragmentManager detecta un cambio en
        //el mensaje.
        //Fragment -> Fragment hijo.

        parentFragmentManager.setFragmentResultListener("bundleMensaje", viewLifecycleOwner) { requestKey, bundle ->
            binding.fragEditTextMensaje.setText(bundle.getString("mensaje"))
        }

        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Al presionar el boton, el estado del mensaje cambia.
        //Fragment -> Activity.

        binding.fragButtonEnviar.setOnClickListener {
            viewModel.setMessage( "Fragmento 2 dijo que " + binding.fragEditTextMensaje.text.toString())
        }

        ////////////////////////////////////////////////////////////////////////////////////////////

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
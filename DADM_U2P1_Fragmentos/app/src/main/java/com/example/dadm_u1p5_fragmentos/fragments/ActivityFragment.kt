package com.example.dadm_u1p5_fragmentos.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.dadm_u1p5_fragmentos.R
import com.example.dadm_u1p5_fragmentos.databinding.FragmentActivityBinding
import com.example.dadm_u1p5_fragmentos.viewmodels.ActivityFragmentViewModel
import com.example.dadm_u1p5_fragmentos.viewmodels.FragmentActivityMensajeViewModel

class ActivityFragment : Fragment() {
    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActivityFragmentViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentActivityBinding.inflate(layoutInflater)

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Observador del mensaje que envia Main Activity.
        //Activity -> Fragment.

        viewModel.mText.observe(viewLifecycleOwner, Observer { text ->
            binding.fragEditTextMensaje.setText(text)
        })

        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Al presionar el boton, enviar mensaje a traves de un bundle en el manejador de fragmentos
        //hijos.
        //Fragmento -> Fragmento hijo.

        binding.fragButtonEnviar.setOnClickListener {
            childFragmentManager.setFragmentResult("bundleMensaje", bundleOf(
                    "mensaje" to "Fragmento 1 dijo que " + binding.fragEditTextMensaje.text.toString()))
        }

        ////////////////////////////////////////////////////////////////////////////////////////////

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
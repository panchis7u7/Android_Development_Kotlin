package com.example.dadm_u1p5_fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.dadm_u1p5_fragmentos.databinding.ActivityMainBinding
import com.example.dadm_u1p5_fragmentos.fragments.ActivityFragment
import com.example.dadm_u1p5_fragmentos.viewmodels.ActivityFragmentViewModel
import com.example.dadm_u1p5_fragmentos.viewmodels.FragmentActivityMensajeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ActivityFragmentViewModel by viewModels()
    private val fragViewModel: FragmentActivityMensajeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val fragmento = supportFragmentManager.findFragmentById(R.id.mainFragmento) as ActivityFragment

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Al presionar el boton, se cambia el mensaje del viewmodel compartido.
        //Activity -> Fragmento.

        binding.buttonEnviar.setOnClickListener {
            binding.editTextMensaje.text.let {
                viewModel.setText("Activity dijo " + it.toString())
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Observador de los eventos del stateFlow que implementa el ultimo fragmento anidado.

        lifecycleScope.launchWhenStarted {
            fragViewModel.messageUiState.collect {
                when(it){
                    is FragmentActivityMensajeViewModel.LatestMessageState.Success -> {
                        binding.editTextMensaje.setText(it.message)
                    }
                    is FragmentActivityMensajeViewModel.LatestMessageState.Empty -> {

                    }
                }
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.example.dadm_u1p5_fragmentos.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.dadm_u1p5_fragmentos.R
import com.example.dadm_u1p5_fragmentos.databinding.FragmentActivityBinding
import com.example.dadm_u1p5_fragmentos.viewmodels.ActivityFragmentViewModel

class ActivityFragment : Fragment() {
    private lateinit var binding: FragmentActivityBinding
    private val viewModel: ActivityFragmentViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        //val fragmento = childFragmentManager.findFragmentById(R.id.innerFragmento) as InnerFragment
        binding = FragmentActivityBinding.inflate(layoutInflater)

        viewModel.mText.observe(viewLifecycleOwner, Observer { text ->
            binding.fragEditTextMensaje.setText(text)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
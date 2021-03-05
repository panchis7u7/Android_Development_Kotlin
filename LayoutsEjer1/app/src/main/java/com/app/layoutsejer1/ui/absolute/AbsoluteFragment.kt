package com.app.layoutsejer1.ui.absolute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.layoutsejer1.R

class AbsoluteFragment : Fragment() {
    private lateinit var absoluteViewModel: AbsoluteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        absoluteViewModel =
            ViewModelProvider(this).get(AbsoluteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absolute, container, false)
        val textView: TextView = root.findViewById(R.id.text_absolute)
        absoluteViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}

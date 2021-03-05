package com.app.layoutsejer1.ui.frame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.layoutsejer1.R

class FrameFragment : Fragment() {
    private lateinit var frameModel: FrameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frameModel =
            ViewModelProvider(this).get(FrameViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_frame, container, false)
        val textView: TextView = root.findViewById(R.id.text_frame)
        frameModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
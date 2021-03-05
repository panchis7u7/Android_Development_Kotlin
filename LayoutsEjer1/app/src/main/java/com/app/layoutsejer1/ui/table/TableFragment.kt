package com.app.layoutsejer1.ui.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.layoutsejer1.R

class TableFragment : Fragment() {

    private lateinit var tableViewModel: TableViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tableViewModel =
                ViewModelProvider(this).get(TableViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_table, container, false)
        val textView: TextView = root.findViewById(R.id.text_table)
        tableViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
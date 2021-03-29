package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u1p4_aplicacion_escolar.Models.GridButton
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gridItemAdapter: RecyclerAdapter
    private var models: MutableList<GridButton> = mutableListOf<GridButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_dashboard)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        binding.mainRecyclerView.layoutManager = gridLayoutManager
        binding.mainRecyclerView.setHasFixedSize(true)
        models = populateList()
        gridItemAdapter = RecyclerAdapter(applicationContext, models)
        binding.mainRecyclerView.adapter = gridItemAdapter
    }

    private fun populateList() : MutableList<GridButton> {
        var items: MutableList<GridButton> = mutableListOf<GridButton>()

        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))
        items.add(GridButton("Hola", "http://simpleicon.com/wp-content/uploads/dashboard.png"))

        return items
    }
}
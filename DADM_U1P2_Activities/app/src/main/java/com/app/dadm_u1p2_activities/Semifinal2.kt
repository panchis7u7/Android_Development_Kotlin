package com.app.dadm_u1p2_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.dadm_u1p2_activities.Models.Civilizacion
import com.app.dadm_u1p2_activities.Models.EditModel

class Semifinal2 : AppCompatActivity() {

    private var modelos = mutableListOf<EditModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semifinal2)

        modelos = populateList()
    }

    private fun populateList(): MutableList<EditModel>{
        return arrayListOf()
    }
}
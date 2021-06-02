package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.adapter.RecyclerContactAdapter
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.model.Contact

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.recyclerViewContact.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerViewContact.adapter = RecyclerContactAdapter(this, populate())
    }

    private fun populate(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        return contacts
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
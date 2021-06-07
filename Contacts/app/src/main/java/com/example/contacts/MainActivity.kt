package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.adapter.RecyclerContactAdapter
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.model.Contact
import com.example.contacts.model.DBManager

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    lateinit var manager : DBManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        manager = DBManager(
            this,
            resources.getString(R.string.db_name),
            null,
            resources.getInteger(R.integer.db_version)
        )

        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                text?.let {
                    refreshContacts()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.fabAgregar.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        refreshContacts()
    }

    private fun refreshContacts() {
        try {
            val contacts = manager.find(binding.editTextSearch.text)

            binding.recyclerViewContact.adapter = RecyclerContactAdapter(this, contacts)
            binding.recyclerViewContact.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /*private fun populate(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        contacts.add(Contact(1, "Carlos Sebastian Madrigal", "4434568765", false, null))
        return contacts
    }*/

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
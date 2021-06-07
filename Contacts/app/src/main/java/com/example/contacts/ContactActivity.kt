package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contacts.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {
    private var _binding: ActivityContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityContactBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_contact)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
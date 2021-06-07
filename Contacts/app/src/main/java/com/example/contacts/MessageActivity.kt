package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.adapter.RecyclerMessageListAdapter
import com.example.contacts.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private var _binding: ActivityMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMessageBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_message)
        setContentView(binding.root)

        /*binding.recyclerGchat.adapter = RecyclerMessageListAdapter(this)
        binding.recyclerGchat.layoutManager = LinearLayoutManager(this)*/

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
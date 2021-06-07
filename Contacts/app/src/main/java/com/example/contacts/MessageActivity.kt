package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.adapter.RecyclerMessageListAdapter
import com.example.contacts.databinding.ActivityMessageBinding
import com.example.contacts.model.Contact
import com.example.contacts.model.Message
import com.example.contacts.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MessageActivity : AppCompatActivity() {
    private var _binding: ActivityMessageBinding? = null
    private val binding get() = _binding!!
    private var mensajes: MutableList<Message> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMessageBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_message)
        setContentView(binding.root)

        var contact: Contact? = null
        if(intent.extras != null) {
            contact = intent.getParcelableExtra("contact")
        }

        binding.toolbarGchannel.title = contact?.name

        binding.buttonGchatSend.setOnClickListener {
            if(binding.editGchatMessage.text.toString().isEmpty()){
                return@setOnClickListener
            } else {
                mensajes.add(
                    Message(binding.editGchatMessage.text.toString(),
                        User.usuarioLocal,
                        System.currentTimeMillis(),
                        Message.VIEW_TYPE_MESSAGE_SENT
                    ))
                binding.recyclerGchat.adapter = RecyclerMessageListAdapter(this, mensajes)
                binding.recyclerGchat.layoutManager = LinearLayoutManager(this)
                GlobalScope.launch(Dispatchers.Main) {
                    onMessageRecived(contact?.name!!)
                }
            }
        }
    }

    suspend fun onMessageRecived(name: String){
        delay(4000L)
        mensajes.add(
            Message("Hola!!",
            User(name, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/the-mandalorian-portada-baby-yoda-1599662623.jpeg?crop=0.522xw:0.392xh;0.149xw,0.239xh&resize=640:*"),
                System.currentTimeMillis(),
            Message.VIEW_TYPE_MESSAGE_RECEIVED)
        )
        binding.recyclerGchat.adapter = RecyclerMessageListAdapter(this, mensajes)
        binding.recyclerGchat.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
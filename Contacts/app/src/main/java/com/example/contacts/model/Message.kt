package com.example.contacts.model

data class Message(
   val message: String,
   val sender: User,
   val createdAt: Long
) {}
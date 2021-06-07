package com.example.contacts.model

data class Message(
   val message: String,
   val sender: User,
   val createdAt: Long,
   val type: Int
) {
   companion object {
      val VIEW_TYPE_MESSAGE_SENT = 1
      val VIEW_TYPE_MESSAGE_RECEIVED = 2
   }
}
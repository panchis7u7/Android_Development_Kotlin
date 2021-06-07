package com.example.contacts.model

data class Contact(
    val id: Int,
    val name: String,
    val celphone: String,
    val favorite: Int?,
    val photo: ByteArray?
) {}
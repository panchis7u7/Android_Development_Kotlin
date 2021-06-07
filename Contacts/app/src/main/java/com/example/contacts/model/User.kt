package com.example.contacts.model

class User(
   val nickname: String,
   val profileURL: String
) {
   companion object {
      var usuarioLocal = User("Sebastian", "https://i.pinimg.com/736x/61/39/2b/61392b5cee6c8563f84b2f058f8a1aa9.jpg")
   }
}
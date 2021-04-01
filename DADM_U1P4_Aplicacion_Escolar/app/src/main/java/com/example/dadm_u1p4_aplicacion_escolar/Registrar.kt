package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Registrar : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null    //Realtime Database.
    var database: FirebaseDatabase? = null  //Firestore database.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registrar)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("alumnos")

        binding.btnRegistrar.setOnClickListener {
            if(TextUtils.isEmpty(binding.textViewControl.text.toString()))
                binding.textViewControl.setError("Porfavor ingresa el no. de control!")
            if(TextUtils.isEmpty(binding.textViewNombre.text.toString()))
                binding.textViewNombre.setError("Porfavor ingrese su nombre.")
            if(TextUtils.isEmpty(binding.textViewCarrera.text.toString()))
                binding.textViewCarrera.setError("Porfavor ingresa su carrera.")
            if(TextUtils.isEmpty(binding.textViewContra.text.toString()))
                binding.textViewContra.setError("Porfavor ingresa una contrasena.")
        }

        auth.createUserWithEmailAndPassword(
            binding.textViewControl.text.toString(),
            binding.textViewContra.text.toString()
        ).addOnCompleteListener {
            if(it.isSuccessful) {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser.uid!!)
                currentUserDb.child("nombre").setValue(binding.textViewNombre.text.toString())
                currentUserDb.child("carrera").setValue(binding.textViewCarrera.text.toString())
                Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, "Error al registrarse! Intente de nuevo!", Toast.LENGTH_LONG).show()
        }

    }
}
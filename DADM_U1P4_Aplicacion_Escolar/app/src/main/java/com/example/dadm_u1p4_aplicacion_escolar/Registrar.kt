package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap

class Registrar : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var fStore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registrar)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Autenticacion de usuarios.
        auth = FirebaseAuth.getInstance()
        fStore = FirebaseFirestore.getInstance()
        register()
    }

    private fun register(){
        binding.btnRegistrar.setOnClickListener {
            var nombre: String = binding.textViewNombre.text.toString().trim()
            var correo: String = binding.textViewControl.text.toString().trim()
            var carrera: String = binding.textViewCarrera.text.toString().trim()
            var contrasena: String = binding.textViewContra.text.toString().trim()

            if(TextUtils.isEmpty(correo)) {
                binding.textViewControl.setError("Porfavor ingresa el no. de control!")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(nombre)) {
                binding.textViewNombre.setError("Porfavor ingrese su nombre.")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(carrera)) {
                binding.textViewCarrera.setError("Porfavor ingresa su carrera.")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(contrasena)){
                binding.textViewContra.setError("Porfavor ingresa una contrasena.")
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(correo, contrasena).addOnCompleteListener {
                if(it.isSuccessful) {
                    val currentUser = auth.currentUser
                    val docRef: DocumentReference = fStore.collection("alumnos").document(currentUser.uid)
                    val alumno: HashMap<String, String> = HashMap()
                    alumno["nombre"] = binding.textViewNombre.text.toString().trim()
                    alumno["carrera"] = binding.textViewCarrera.text.toString().trim()
                    docRef.set(alumno).addOnSuccessListener {
                        Toast.makeText(this@Registrar, "Registro exitoso!", Toast.LENGTH_LONG).show()
                        finish()
                    }
                } else
                    Toast.makeText(this@Registrar, "Error al registrarse! Intente de nuevo!", Toast.LENGTH_LONG).show()
                    Log.d("UserCreate", "Error al crear usuario: ${binding.textViewControl.toString().trim()}, ${contrasena} " + it.exception)
            }
        }
    }
}
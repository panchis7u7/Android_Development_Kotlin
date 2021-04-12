package com.example.dadm_u1p4_aplicacion_escolar

import android.R
import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import com.example.dadm_u1p4_aplicacion_escolar.Models.Semestre
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.HashMap

class Registrar : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var mDateSetListener: DatePickerDialog.OnDateSetListener

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registrar)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Autenticacion de usuarios.
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        binding.textViewNacimiento.setOnClickListener{
            var cal: Calendar = Calendar.getInstance()
            var anio = cal.get(Calendar.YEAR)
            var mes = cal.get(Calendar.MONTH)
            var dia = cal.get(Calendar.DAY_OF_MONTH)

            var dialog: DatePickerDialog = DatePickerDialog(
            this@Registrar,
            R.style.Theme_Material_Light_Dialog,
            mDateSetListener, anio, mes, dia)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            dialog.show()
        }

        mDateSetListener = DatePickerDialog.OnDateSetListener{ view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
            binding.textViewNacimiento.text = "${dayOfMonth}/${month}/${year}"
        }

        register()
    }

    private fun register(){
        binding.btnRegistrar.setOnClickListener {
            var nombre: String = binding.textViewNombre.text.toString().trim()
            var correo: String = binding.textViewCorreo.text.toString().trim()
            var nocontrol: String = binding.textViewControl.text.toString().trim()
            var carrera: String = binding.textViewCarrera.text.toString().trim()
            var contrasena: String = binding.textViewContra.text.toString().trim()
            var genero: String = binding.spinnerGenero.selectedItem.toString().trim()
            var nacimiento: String = binding.textViewNacimiento.text.toString().trim()

            if(TextUtils.isEmpty(correo)) {
                binding.textViewCorreo.setError("Porfavor ingresa su correo electronico.")
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
            } else if(TextUtils.isEmpty(nocontrol)) {
                binding.textViewControl.setError("Porfavor ingresa su numero de control.")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(nacimiento)){
                binding.textViewNacimiento.setError("Porfavor ingresa una fecha de nacimiento valida.")
                return@setOnClickListener
        } else {

            auth.createUserWithEmailAndPassword(correo, contrasena).addOnCompleteListener {
                if(it.isSuccessful) {
                    val currentUser = auth.currentUser
                    val docRef: DocumentReference = db.collection("alumnos").document(currentUser.uid)
                    val alumno: HashMap<String, String> = HashMap()
                    alumno["nombre"] = nombre
                    alumno["carrera"] = carrera
                    alumno["correo"] = correo
                    alumno["noControl"] = nocontrol
                    alumno["fotografia"] = ""
                    alumno["curp"] = ""
                    alumno["fechaNacimiento"] = nacimiento
                    alumno["sexo"] = genero
                    alumno["calle"] = ""
                    alumno["municipio"] = ""
                    alumno["estado"] = ""
                    alumno["colonia"] = ""
                    alumno["codigoPostal"] = ""
                    alumno["telefono"] = ""

                    docRef.set(alumno).addOnSuccessListener {
                        Toast.makeText(this@Registrar, "Registro exitoso!", Toast.LENGTH_LONG).show()
                        finish()
                    }
                } else {
                    Toast.makeText(this@Registrar,
                        "Error al registrarse! Intente de nuevo!",
                        Toast.LENGTH_LONG).show()
                    Log.d("UserCreate",
                        "Error al crear usuario: ${
                            binding.textViewControl.toString().trim()
                        }, ${contrasena} " + it.exception)
                    }
                }
            }
        }
    }
}
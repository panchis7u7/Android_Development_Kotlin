package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso

class Perfil : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_perfil)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        db.collection("alumnos").document(auth.currentUser.uid).get()
            .addOnSuccessListener { document ->
                if (document != null){
                    binding.editTextImagen.setText((document.get("fotografia") as String))
                    if((document.get("fotografia") as String).isNotEmpty())
                    try {
                        Picasso.get().load((document.get("fotografia") as String)).into(binding.imageViewAlumno)
                    } catch (e: Exception){
                        Toast.makeText(this, "Error con la imagen!", Toast.LENGTH_LONG).show()
                    }
                    binding.textViewNombre.text = (document.get("nombre") as String)
                    binding.textViewControl.text = (document.get("noControl") as String)
                    binding.textViewCarrera.text = (document.get("carrera") as String)
                    binding.textViewCorreo.text = (document.get("correo") as String)
                    binding.textViewCurp.text = (document.get("curp") as String)
                    binding.textViewNacimiento.text = (document.get("fechaNacimiento") as String)
                    binding.textViewSexo.text = (document.get("sexo") as String)
                    binding.editTextCalleNumero.setText((document.get("calle") as String))
                    binding.editTextMunicipio.setText((document.get("municipio") as String))
                    binding.editTextEstado.setText((document.get("estado") as String))
                    binding.editTextColonia.setText((document.get("colonia") as String))
                    binding.editTextCodigoPostal.setText((document.get("codigoPostal") as String))
                    binding.editTextTelefono.setText((document.get("telefono") as String))
                } else {
                    Log.d("Error", "Error: No such document")
                }
            }

        binding.buttonAlumno.setOnClickListener{
            var alumno: MutableMap<String, Any> = hashMapOf()
            alumno.put("fotografia", binding.editTextImagen.getText().toString())
            alumno.put("calle", binding.editTextCalleNumero.text.toString())
            alumno.put("municipio", binding.editTextMunicipio.text.toString())
            alumno.put("estado", binding.editTextEstado.text.toString())
            alumno.put("colonia", binding.editTextColonia.text.toString())
            alumno.put("codigoPostal", binding.editTextCodigoPostal.text.toString())
            alumno.put("telefono", binding.editTextTelefono.text.toString())

            db.collection("alumnos").document(auth.currentUser.uid).update(alumno)
        }
    }
}
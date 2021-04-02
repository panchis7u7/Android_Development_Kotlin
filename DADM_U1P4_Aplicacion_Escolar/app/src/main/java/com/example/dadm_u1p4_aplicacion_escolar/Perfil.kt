package com.example.dadm_u1p4_aplicacion_escolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dadm_u1p4_aplicacion_escolar.Models.Alumno
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityPerfilBinding
import com.squareup.picasso.Picasso

class Perfil : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_perfil)
        setContentView(binding.root)

        var alumno: Alumno = Alumno("Carlos Sebastian",
            "https://morelia.tecsge.com/storage/data/alumnos/18121699/foto.jpg",
            "ITics",
            "18121699",
            "l18121699@morelia.tecnm.mx")

        Picasso.get().load(alumno.fotografia).into(binding.imageViewAlumno)

        binding.alumnoNombre.setText(alumno.nombre)
        binding.alumnoCarrera.setText(alumno.carrera)
        binding.alumnoControl.setText(alumno.noControl)
        binding.alumnoCorreo.setText(alumno.correo)

    }
}
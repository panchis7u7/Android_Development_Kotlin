package com.example.dadm_u1p4_aplicacion_escolar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.dadm_u1p4_aplicacion_escolar.databinding.ActivityLoginBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    companion object {
        lateinit var auth: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_login)
        setContentView(binding.root)

        //Analytics.
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle: Bundle = Bundle()
        bundle.putString("message", "Integracion de firebase exitosa.")
        analytics.logEvent("InitScreen", bundle)

        //Authentication instance.
        auth = FirebaseAuth.getInstance()

        binding.textRegister.setOnClickListener {
            var intent: Intent = Intent(this, Registrar::class.java)
            startActivity(intent)
        }

        if(FirebaseAuth.getInstance().currentUser != null) {
            val intent = Intent(this@Login, Dashboard::class.java)
            startActivity(intent)
        } else
            login()
    }

    private fun login(){
        binding.btnLogin.setOnClickListener{
            if(binding.textViewControl.text.isNotEmpty() && binding.textViewContra.text.isNotEmpty()){
                auth.signInWithEmailAndPassword(
                    binding.textViewControl.text.toString(),
                    binding.textViewContra.text.toString()
                ).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this@Login, Dashboard::class.java)
                        startActivity(intent)
                    } else {
                        val builder = AlertDialog.Builder(this@Login)
                        builder.setTitle("Error")
                        builder.setMessage("Se ha producido un error con la autenticacion del usuario.")
                        builder.setPositiveButton("Aceptar", null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                    }
                }
            } else {
                val builder = AlertDialog.Builder(this@Login)
                builder.setTitle("Error")
                builder.setMessage("Falto de ingresar datos a los campos.")
                builder.setPositiveButton("Aceptar", null)
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
    }
}
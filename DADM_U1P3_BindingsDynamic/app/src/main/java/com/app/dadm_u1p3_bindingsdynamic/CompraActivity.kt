package com.app.dadm_u1p3_bindingsdynamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.dadm_u1p3_bindingsdynamic.databinding.ActivityCompraBinding
import com.app.dadm_u1p3_bindingsdynamic.models.EntradaCine

class CompraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_compra)
        binding = ActivityCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val datos = intent.getStringArrayExtra("datos")
        intent?.let {
            val user: EntradaCine = it.extras!!.getParcelable<EntradaCine>("entrada") as EntradaCine
            binding.txtCompra.text = """¡¡Gracias por tu compra!!!
            |
            |Película: ${user.pelicula}
            |Sala: ${user.sala}
            |Horario: ${user.horario}
            |Boletos: ${user.boletos}
        """.trimMargin()
        }
    }
}
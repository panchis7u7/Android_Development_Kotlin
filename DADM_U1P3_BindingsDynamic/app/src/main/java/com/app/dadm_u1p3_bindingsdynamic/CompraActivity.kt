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
            val entrada: EntradaCine = it.extras!!.getParcelable<EntradaCine>("entrada") as EntradaCine
            binding.txtCompra.text = """¡¡${getString(R.string.graciasCompra)}!!!
            |
            |${getString(R.string.pelicula)}: ${entrada.pelicula}
            |${getString(R.string.sala)}: ${entrada.sala}
            |${getString(R.string.horario)}: ${entrada.horario}
            |${getString(R.string.boletos)}: ${entrada.nBoletos}
        """.trimMargin()
        }
    }
}
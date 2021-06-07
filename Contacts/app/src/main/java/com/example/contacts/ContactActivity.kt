package com.example.contacts

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.contacts.Utils.Companion.toast
import com.example.contacts.databinding.ActivityContactBinding
import com.example.contacts.model.Contact
import com.example.contacts.model.DBManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayOutputStream

class ContactActivity : AppCompatActivity() {
    private var _binding: ActivityContactBinding? = null
    private val binding get() = _binding!!

    var byteFoto : ByteArray? = null
    lateinit var manager : DBManager
    var isEdit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityContactBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_contact)
        setContentView(binding.root)

        var contact: Contact? = null
        if(intent.extras != null) {
            contact = intent.getParcelableExtra<Contact>("contact")
            isEdit = true
        }

        if(isEdit){
            binding.editName.setText(contact?.name)
            binding.editCel.setText(contact?.celphone)
            contact?.photo?.let {
                binding.imgContact.setImageBitmap(BitmapFactory.decodeByteArray(it, 0, it.size))
            }
            binding.tgBtnFav.isChecked = contact?.favorite == 1
        }

        manager = DBManager(
            this,
            resources.getString(R.string.db_name),
            null,
            resources.getInteger(R.integer.db_version)
        )

        binding.fabEditPhoto.setOnClickListener {
            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "image/*"

            val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"

            val chooserIntent = Intent.createChooser(getIntent, "Select Image")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

            startActivityForResult(chooserIntent, 1)
        }

        binding.tgBtnFav.setOnClickListener {
            if(binding.tgBtnFav.isSelected) {
                binding.tgBtnFav.textOn = "Es favorito"
                binding.tgBtnFav.setCompoundDrawablesWithIntrinsicBounds(
                    null, resources.getDrawable(android.R.drawable.star_big_on), null, null
                )
            } else {
                binding.tgBtnFav.textOff = "No es favorito"
                binding.tgBtnFav.setCompoundDrawablesWithIntrinsicBounds(
                    null, resources.getDrawable(android.R.drawable.star_big_off), null, null
                )
            }
        }

        binding.btnCancelar.setOnClickListener { finish() }

        binding.btnGuardar.setOnClickListener {
            var validated = true
            if(binding.editName.text.isEmpty()) {
                validated = false
                binding.editName.setError("El nombre es requerido")
            }
            if(binding.editCel.text.isEmpty()) {
                validated = false
                binding.editCel.setError("El celular es requerido")
            }
            // Si todo es correcto
            if(validated) {
                val contacto = Contact(
                    0,
                    binding.editName.text.toString(),
                    binding.editCel.text.toString(),
                    if(binding.tgBtnFav.isSelected) 1 else 0,
                    byteFoto
                )
                // Se guarda en la BD
                try {
                    manager.create(contacto)

                    "Se agrego el contacto ${binding.editName.text}".toast(this)
                } catch (e: Exception) {
                    e.printStackTrace()

                    "Error al crear el contacto".toast(this)
                }
                finish()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            data?.let {
                val uri = it.data
                val baos = ByteArrayOutputStream()
                try {
                    it.data?.let {
                        val fis = contentResolver.openInputStream(it)

                        fis?.let {
                            val buf = ByteArray(1024)
                            do {
                                val n = it.read(buf)
                                if(n != -1) {
                                    baos.write(buf, 0, n)
                                } else break
                            } while (true)

                            byteFoto = baos.toByteArray()
                        }
                    }

                    // Actualizar imageView
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                    binding.imgContact.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
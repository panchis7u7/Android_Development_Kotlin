package com.example.dadm_u2p2_cine

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadm_u2p2_cine.adapter.RecyclerPeliculasAdapter
import com.example.dadm_u2p2_cine.adapter.RecyclerPeliculasItemAdapter
import com.example.dadm_u2p2_cine.databinding.ActivityMainBinding
import com.example.dadm_u2p2_cine.fragment.HomeFragment
import com.example.dadm_u2p2_cine.model.Categoria
import com.example.dadm_u2p2_cine.model.Pelicula

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        supportActionBar?.let {
            it.title = "Cinepolis V2"
            it.setDefaultDisplayHomeAsUpEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }
        //supportFragmentManager.findFragmentById(R.id.fragmentHome) as HomeFragment

        setFullScreen()
        binding.bottomNavigationView.background = null
        binding.bottomAppBar.background = null
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        super.navigateUpTo(upIntent)
        onBackPressed()
        return true
    }

    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
            val controller = window.insetsController
            if (controller != null) {
                /*controller.hide(WindowInsets.Type.navigationBars()
                        or WindowInsets.Type.captionBar())*/
                controller.hide(WindowInsets.Type.captionBar())
                //supportActionBar?.hide()
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            // All below using to hide navigation bar
            val currentApiVersion = Build.VERSION.SDK_INT
            val flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

            // This work only for android 4.4+
            if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
                window.decorView.systemUiVisibility = flags
                // Code below is to handle presses of Volume up or Volume down.
                // Without this, after pressing volume buttons, the navigation bar will
                // show up and won't hide
                val decorView = window.decorView
                decorView.setOnSystemUiVisibilityChangeListener { visibility: Int ->
                    if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                        decorView.systemUiVisibility = flags
                    }
                }
            }
        }
    }
}
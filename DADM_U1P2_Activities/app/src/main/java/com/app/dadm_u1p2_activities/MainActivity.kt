package com.app.dadm_u1p2_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        Picasso.get().load("https://i.pinimg.com/236x/f1/09/5c/f1095caa7a1f3ee9a9409e57d7325fc7--futbol-soccer-tattoo-ideas.jpg").into(imageView);

        var imageView2: ImageView = findViewById<ImageView>(R.id.imageView2)
        Picasso.get().load("https://img.icons8.com/color/452/barcelona-fc.png").into(imageView2);
    }
}
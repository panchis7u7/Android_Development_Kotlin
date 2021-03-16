package com.app.dadm_u1p2_activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_winner.*
import nl.dionsegijn.konfetti.models.Size
import nl.dionsegijn.konfetti.models.Shape

class WinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        viewConfetti.build()
            .addColors(Color.CYAN, Color.RED, Color.BLACK)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(-50f, viewConfetti.width+50f, -50f)
            .streamFor(300, 3000L)
        civilizacionGanadora.text = intent.getStringExtra("ganador").toString()
        Picasso.get().load(intent.getStringExtra("imagenGanador")).into(imagenCivilizacionGanadora);
    }
}
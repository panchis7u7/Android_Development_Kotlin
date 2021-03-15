package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var nombresEquiposCasa = mutableListOf<String>()
    private var nombresEquiposVisitantes = mutableListOf<String>()
    private var imagenesEquiposCasa = mutableListOf<String>()
    private var imagenesEquiposVisitante = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = RecyclerAdapter(nombresEquiposCasa,
                                                   nombresEquiposVisitantes,
                                                   imagenesEquiposCasa,
                                                   imagenesEquiposVisitante)

        //btnSigS1.setOnClickListener{
        //    val intent = Intent(this, Semifinal2::class.java)
        //    startActivity(intent)
        //}

        //var imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        //Picasso.get().load("https://i.pinimg.com/236x/f1/09/5c/f1095caa7a1f3ee9a9409e57d7325fc7--futbol-soccer-tattoo-ideas.jpg").into(imageView);

        //var imageView2: ImageView = findViewById<ImageView>(R.id.imageView2)
        //Picasso.get().load("https://img.icons8.com/color/452/barcelona-fc.png").into(imageView2);
    }

    private fun addToList(nCasa: String, nVisitante: String, iCasa: String, iVisitante: String){
        nombresEquiposCasa.add(nCasa)
        nombresEquiposVisitantes.add(nVisitante)
        imagenesEquiposCasa.add(iCasa)
        imagenesEquiposVisitante.add(iVisitante)
    }

    private fun postToList(){
        addToList("Persas", "Vikingos",
        "https://img3.freepng.es/dy/167d91e2b1e14bbb6c9e00bf8d6b150e/L0KzQYm3U8E6N6lBj5H0aYP2gLBuTfFzbZIyiAt2YnBvPb32hB8ubpDzjJ9ycnHxPYbogsA3OmE3SNRtZUO8PoaBWcQxP2Y6Sac7MUWzSIm9VsA1QGcziNDw/kisspng-area-symbol-logo-font-iran-5ab062020bde39.5894075515215088660486.png",
            "https://i.pinimg.com/originals/6f/7b/e5/6f7be576c51c4070dd20d51aa7751b52.png")
        addToList("Teutones", "Aztecas",
        "https://static.wikia.nocookie.net/theassassinscreed/images/1/12/Teut%C3%B3nicos.png/revision/latest/scale-to-width-down/600?cb=20160207152744&path-prefix=es",
        "https://dbdzm869oupei.cloudfront.net/img/sticker/preview/12305.png")
        addToList("Japoneses", "Sarracenos",
            "https://i.pinimg.com/originals/91/3c/f2/913cf2a19bf069f8df2ef9096f14b355.png",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Cross_of_Saint_James.svg/1200px-Cross_of_Saint_James.svg.png")
        addToList("Españoles", "Vietnamitas",
            "https://i.pinimg.com/originals/c3/12/d8/c312d830c69d8e795045a2e7cc43d025.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Rounded_symbol_for_shuangxi-U-1F264.svg/1200px-Rounded_symbol_for_shuangxi-U-1F264.svg.png"
        )
    }

}
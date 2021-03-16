package com.app.dadm_u1p2_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.dadm_u1p2_activities.Models.EditModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private var modelos = mutableListOf<EditModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        modelos = populateList()

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = RecyclerAdapter(this, modelos)

        btnSigS1.setOnClickListener{
            for(i in 0 .. RecyclerAdapter.models.size-1){
                Log.d("$i: ", RecyclerAdapter.models.get(i).getEquipoCasa() +
                        RecyclerAdapter.models.get(i).getEquipoVisitante())
            }
            //val intent = Intent(this, Semifinal2::class.java)
            //startActivity(intent)
        }
    }

    private fun populateList(): MutableList<EditModel>{
        var modelos: MutableList<EditModel> = arrayListOf()
        modelos.add(EditModel("Persas", "Vikingos",
                "https://img3.freepng.es/dy/167d91e2b1e14bbb6c9e00bf8d6b150e/L0KzQYm3U8E6N6lBj5H0aYP2gLBuTfFzbZIyiAt2YnBvPb32hB8ubpDzjJ9ycnHxPYbogsA3OmE3SNRtZUO8PoaBWcQxP2Y6Sac7MUWzSIm9VsA1QGcziNDw/kisspng-area-symbol-logo-font-iran-5ab062020bde39.5894075515215088660486.png",
                "https://i.pinimg.com/originals/6f/7b/e5/6f7be576c51c4070dd20d51aa7751b52.png"))
        modelos.add(EditModel("Teutones", "Aztecas",
                "https://static.wikia.nocookie.net/theassassinscreed/images/1/12/Teut%C3%B3nicos.png/revision/latest/scale-to-width-down/600?cb=20160207152744&path-prefix=es",
                "https://dbdzm869oupei.cloudfront.net/img/sticker/preview/12305.png"))
        modelos.add(EditModel("Japoneses", "Sarracenos",
                "https://i.pinimg.com/originals/91/3c/f2/913cf2a19bf069f8df2ef9096f14b355.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Cross_of_Saint_James.svg/1200px-Cross_of_Saint_James.svg.png"))
        modelos.add(EditModel("Españoles", "Vietnamitas",
                "https://i.pinimg.com/originals/c3/12/d8/c312d830c69d8e795045a2e7cc43d025.png",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Rounded_symbol_for_shuangxi-U-1F264.svg/1200px-Rounded_symbol_for_shuangxi-U-1F264.svg.png"))
        return modelos
    }

}
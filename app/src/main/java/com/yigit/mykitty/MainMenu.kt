package com.yigit.mykitty

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
         //val urlh="https://api.thecatapi.com/v1/images/search?category_ids=5"

        val i:Intent=Intent()
        val imgv = findViewById<ImageView>(R.id.random_cat_image)
        val jsontoview:JsontoView=JsontoView()
       val urlh:String="https://api.thecatapi.com/v1/images/search?api_key=YOUR KEY HERE"
        Glide.with(this).load(R.drawable.loading).into(random_cat_image)
        jsontoview.fetchJson(this,urlh,imgv,findViewById(R.id.welcome_text),false,urlholderMain)

        buttonBreeds.setOnClickListener ({
            val i:Intent=Intent(this,BreedsList::class.java)
            startActivity(i)

        })

        buttonCategories.setOnClickListener({
        val i:Intent=Intent(this,ItemsList::class.java)
        startActivity(i)})


        buttonRandom.setOnClickListener({

            val i:Intent=Intent(this,DesciptionActivity::class.java)
            startActivity(i)
        })
    }
}

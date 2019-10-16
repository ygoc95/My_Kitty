package com.yigit.mykitty

import android.app.LauncherActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
         //val urlh="https://api.thecatapi.com/v1/images/search?category_ids=5"

        val i:Intent=Intent()
        val imgv = findViewById<ImageView>(R.id.random_cat_image)
        val jsontoview:JsontoView=JsontoView()
       val urlh:String="https://api.thecatapi.com/v1/images/search?api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"
        jsontoview.fetchJson(this,urlh,imgv,findViewById(R.id.welcome_text),false)

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

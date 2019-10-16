package com.yigit.mykitty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_items_list.*

class ItemsList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_list)
        //https://api.thecatapi.com/v1/images/search?category_ids=5&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d

        val jsontoview:JsontoView=JsontoView()
        image_box.setOnClickListener({ActivtyMaker("5")})
        image_glasses.setOnClickListener({ActivtyMaker("4")})
        image_space.setOnClickListener({ActivtyMaker("2")})
        image_hats.setOnClickListener({ActivtyMaker("1")})
        image_clothes.setOnClickListener({ActivtyMaker("15")})



    }

    fun ActivtyMaker(idNo:String){

        val intent = Intent(this, DesciptionActivity::class.java)
        intent.putExtra("category_id", idNo)
        startActivity(intent)


    }

}

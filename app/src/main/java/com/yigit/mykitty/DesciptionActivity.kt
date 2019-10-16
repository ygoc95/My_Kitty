package com.yigit.mykitty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class DesciptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsontoview:JsontoView=JsontoView()

        if(intent.getStringExtra("breed_id").isNullOrEmpty()!==true)
        { val ss:String = intent.getStringExtra("breed_id")

        jsontoview.fetchJson(this,breedurlmaker(ss),cat_image,catDescription,true)}
        else if (intent.getStringExtra("category_id").isNullOrEmpty()!==true){

            val ss:String = intent.getStringExtra("category_id")
            jsontoview.fetchJson(this,categurlmaker(ss),cat_image,catDescription,false)

    }
        else
        {
            jsontoview.fetchJson(this,"https://api.thecatapi.com/v1/images/search?api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d",cat_image,catDescription,false)

        }




    }
    fun breedurlmaker( id:String): String {


        val str="https://api.thecatapi.com/v1/images/search?breed_id="+id+"&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"


        return str

    }
    fun categurlmaker( id:String): String {


        val str="https://api.thecatapi.com/v1/images/search?category_ids="+id+"&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"


        return str

    }




}

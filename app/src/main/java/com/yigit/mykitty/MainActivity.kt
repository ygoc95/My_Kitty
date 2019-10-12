package com.yigit.mykitty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import okhttp3.*
import java.io.IOException
import java.io.ObjectInput

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgv = findViewById<ImageView>(R.id.random_cat_image)
        fetchJson()


    }

    fun fetchJson(){

        val urlh="https://api.thecatapi.com/v1/images/search?api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"
        println("trying to fetch json GOOD LUCK")

        val client = OkHttpClient()
        val request = Request.Builder().url(urlh).build()
        client.newCall(request).enqueue(object :Callback{

            override fun onFailure(call: Call, e: IOException) {

                println("FAILED BUT KEEP TRYING")

            }

            override fun onResponse(call: Call, response: Response) {

                println("OnResponse initiated")
                val body=response?.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val baselist:List<Base1164617114> = gson.fromJson(body,Array<Base1164617114>::class.java).toList()
                val url:String=baselist[0].url.toString()
                println(url)
                this@MainActivity.runOnUiThread(java.lang.Runnable {

                    Picasso.get().load(url).into(findViewById<ImageView>(R.id.random_cat_image))

                })



            }

        })


    }

    data class Base1164617114(val breeds: List<Any>?, val id: String?, val url: String?, val width: Number?, val height: Number?)



}

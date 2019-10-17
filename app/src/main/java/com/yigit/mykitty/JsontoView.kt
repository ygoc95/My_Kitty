package com.yigit.mykitty

import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import okhttp3.*
import java.io.IOException

class JsontoView {

        var imgurl:String= String()



    fun fetchJson(activity: Activity,weburl:String, imgv: ImageView, txtvw: TextView,setText:Boolean,urltxt:TextView) //This function takes url, an imageview for image and textview for description

    {
       // val urlh="https://api.thecatapi.com/v1/images/search?breed_id=beng&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"

        //val urlh="https://api.thecatapi.com/v1/images/search?api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"

        val client = OkHttpClient()
        val request = Request.Builder().url(weburl).build()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {

                println("FAILED BUT KEEP TRYING")

            }

            override fun onResponse(call: Call, response: Response) {

                println("OnResponse initiated")
                val body=response?.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val baselist:List<Base583746887> = gson.fromJson(body,Array<Base583746887>::class.java).toList() //this JSON starts as an array, therefore we need to refer it as a list object everytime we try to access it
                val url:String=baselist[0].url.toString()
                var desc:String?="Item description not found"
                if(baselist[0].breeds.isNullOrEmpty()!==true) //random JSON calls refer to no breeds therefore we need to check if breeds[] array is empty or not. Gives Okhttp dispacther error if not handled.
                {val breed: Breeds477241899? = baselist[0].breeds?.get(0)

                desc = breed?.description}

                println(url)
                activity.runOnUiThread(java.lang.Runnable {

                    Picasso.get().load(url).fit().centerCrop().into(imgv)



                    if(setText==true){
                        txtvw.setText(desc)}

                   urltxt.setText(url)


                })



            }

        })


    }



    data class Base583746887(val breeds: List<Breeds477241899>?, val id: String?, val url: String?, val width: Number?, val height: Number?)

    data class Breeds477241899(val weight: Weight?, val id: String?, val name: String?, val cfa_url: String?, val vetstreet_url: String?, val vcahospitals_url: String?, val temperament: String?, val origin: String?, val country_codes: String?, val country_code: String?, val description: String?, val life_span: String?, val indoor: Number?, val lap: Number?, val adaptability: Number?, val affection_level: Number?, val child_friendly: Number?, val cat_friendly: Number?, val dog_friendly: Number?, val energy_level: Number?, val grooming: Number?, val health_issues: Number?, val intelligence: Number?, val shedding_level: Number?, val social_needs: Number?, val stranger_friendly: Number?, val vocalisation: Number?, val bidability: Number?, val experimental: Number?, val hairless: Number?, val natural: Number?, val rare: Number?, val rex: Number?, val suppressed_tail: Number?, val short_legs: Number?, val wikipedia_url: String?, val hypoallergenic: Number?)

    data class Weight(val imperial: String?, val metric: String?)

}
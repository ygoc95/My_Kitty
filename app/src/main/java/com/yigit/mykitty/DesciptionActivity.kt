package com.yigit.mykitty

import android.Manifest
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.huxq17.download.DownloadConfig
import com.huxq17.download.Pump
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class DesciptionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsontoview: JsontoView = JsontoView()
        var jsonurl:String="https://api.thecatapi.com/v1/images/search?api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"
        //val imageurlpath:String

        DownloadConfig.newBuilder(getApplicationContext())
            .setMaxRunningTaskNum(1)
            .build();

        if (intent.getStringExtra("breed_id").isNullOrEmpty() !== true) { // intent will have this extra if it's coming from breed activity
            val ss: String = intent.getStringExtra("breed_id")
            jsonurl=breedurlmaker(ss)
         jsontoview.fetchJson(this, jsonurl, cat_image, catDescription, true,urlholder)
            //imageurlpath=jsontoview.imgurl


        } else if (intent.getStringExtra("category_id").isNullOrEmpty() !== true) {  // intent will have this extra if it's coming category activity

            val ss: String = intent.getStringExtra("category_id")
            jsonurl=categurlmaker(ss)
            jsontoview.fetchJson(this, jsonurl, cat_image, catDescription, false,urlholder)
            //imageurlpath=jsontoview.imgurl


        } else {
            jsontoview.fetchJson(this,jsonurl,cat_image,catDescription,false,urlholder)


        }
        save_button.setOnClickListener({methodWithPermissions(urlholder.text.toString())})

        println(urlholder.text.toString()+"THIS IS URL")


    }
        fun breedurlmaker(id: String): String {  //url function for breed search


            val str =
                "https://api.thecatapi.com/v1/images/search?breed_id=" + id + "&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"


            return str

        }

        fun categurlmaker(id: String): String { //url function for category search

            val str =
                "https://api.thecatapi.com/v1/images/search?category_ids=" + id + "&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"

            return str
        }


        fun methodWithPermissions(string: String) = runWithPermissions(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    ) {
        Toast.makeText(this,"Started downloading",Toast.LENGTH_SHORT).show()
            val file1 = File(Environment.getExternalStorageDirectory(), "cat.jpg")
            println(Environment.getExternalStorageDirectory().toString())
            Pump.newRequest(string, file1.absolutePath)
                .forceReDownload(false)
                .threadNum(3)
                .tag("tagCat")
                .submit()
            println("Download Finished")
            Toast.makeText(this,"Saved as 'cat.jpg' in your external storage",Toast.LENGTH_SHORT).show()


            Pump.deleteByTag("tagCat")

            }




    }



package com.yigit.mykitty

import android.Manifest
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.huxq17.download.DownloadConfig
import com.huxq17.download.Pump
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.save_dialog.view.*
import java.io.File


class DesciptionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsontoview: JsontoView = JsontoView()
        var jsonurl:String="https://api.thecatapi.com/v1/images/search?api_key="
        //val imageurlpath:String
        Glide.with(this).load(R.drawable.loading).into(cat_image)

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
        //save_button.setOnClickListener({methodWithPermissions(urlholder.text.toString(),image_name.text.toString())})

        save_button.setOnClickListener {

            val savedialog:View= LayoutInflater.from(this).inflate(R.layout.save_dialog,null)
            val saveDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            saveDialogBuilder.setView(savedialog)
            saveDialogBuilder.setCancelable(true)
            saveDialogBuilder.setPositiveButton("SAVE"){_, _ ->

                var imagefilename:String = savedialog.editTextDialogUserInput.text.toString()
                //Toast.makeText(this,"You said: " +imagefilename,Toast.LENGTH_LONG).show()

                methodWithPermissions(urlholder.text.toString(),imagefilename)

            }
            saveDialogBuilder.create()
            saveDialogBuilder.show()


        }

        println(urlholder.text.toString()+"THIS IS URL")

        refresh_button.setOnClickListener{recreate()}


    }
        fun breedurlmaker(id: String): String {  //url function for breed search


            val str =
                "https://api.thecatapi.com/v1/images/search?breed_id=" + id + "&api_key=KEY HERE"


            return str

        }

        fun categurlmaker(id: String): String { //url function for category search

            val str =
                "https://api.thecatapi.com/v1/images/search?category_ids=" + id + "&api_key="

            return str
        }


        fun methodWithPermissions(urlStr: String,filename: String) = runWithPermissions(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    ) {
        Toast.makeText(this,"Started downloading",Toast.LENGTH_SHORT).show()
            val file1 = File(Environment.getExternalStorageDirectory(),filename+".jpg")
            println(Environment.getExternalStorageDirectory().toString())
            Pump.newRequest(urlStr, file1.absolutePath)
                .forceReDownload(false)
                .threadNum(3)
                .tag("tagCat")
                .submit()
            println("Download Finished")
            Toast.makeText(this,"Saved as "+filename+" to"+getExternalStorageDirectory().toString(),Toast.LENGTH_SHORT).show()


            Pump.deleteByTag("tagCat")

            }




    }



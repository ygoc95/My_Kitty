package com.yigit.mykitty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_breeds_list.*

class BreedsList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breeds_list)



        val jsontoview:JsontoView=JsontoView()
        jsontoview.fetchJson(this,urlmaker("bsho"),findViewById(R.id.bosho),findViewById(R.id.boshotxt),false)
        jsontoview.fetchJson(this,urlmaker("sphy"),findViewById(R.id.sphy),findViewById(R.id.boshotxt),false)
        jsontoview.fetchJson(this,urlmaker("tvan"),findViewById(R.id.tvan),findViewById(R.id.boshotxt),false)
       jsontoview.fetchJson(this,urlmaker("siam"),findViewById(R.id.siam),findViewById(R.id.boshotxt),false)
       jsontoview.fetchJson(this,urlmaker("pers"),findViewById(R.id.pers),findViewById(R.id.boshotxt),false)
       jsontoview.fetchJson(this,urlmaker("ragd"),findViewById(R.id.ragd),findViewById(R.id.boshotxt),false)
        jsontoview.fetchJson(this,urlmaker("mcoo"),findViewById(R.id.mcoo),findViewById(R.id.boshotxt),false)


        bosho.setOnClickListener({ActivtyMaker("bsho")})
        sphy.setOnClickListener({ActivtyMaker("sphy")})
        tvan.setOnClickListener({ActivtyMaker("tvan")})
        siam.setOnClickListener({ActivtyMaker("siam")})
        pers.setOnClickListener({ActivtyMaker("pers")})
        ragd.setOnClickListener({ActivtyMaker("ragd")})
        mcoo.setOnClickListener({ActivtyMaker("mcoo")})




    }

    fun ActivtyMaker(idNo:String){

        val intent = Intent(this, DesciptionActivity::class.java)
        intent.putExtra("breed_id", idNo)
        startActivity(intent)


    }


    fun urlmaker( id:String): String {


       val str="https://api.thecatapi.com/v1/images/search?breed_id="+id+"&api_key=92e453f8-d396-4777-bb4a-9f612e2dfa1d"


        return str

    }

}

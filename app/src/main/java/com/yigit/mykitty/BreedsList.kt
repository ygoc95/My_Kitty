package com.yigit.mykitty

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_breeds_list.*

class BreedsList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breeds_list)



        val jsontoview:JsontoView=JsontoView()
        jsontoview.fetchJson(this,urlmaker("bsho"),findViewById(R.id.bsho),findViewById(R.id.bshotext),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("sphy"),findViewById(R.id.sphy),findViewById(R.id.sphytxt),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("tvan"),findViewById(R.id.tvan),findViewById(R.id.texttvan),false,urlholderBreeds)
       jsontoview.fetchJson(this,urlmaker("siam"),findViewById(R.id.siam),findViewById(R.id.textsiam),false,urlholderBreeds)
       jsontoview.fetchJson(this,urlmaker("pers"),findViewById(R.id.pers),findViewById(R.id.textpers),false,urlholderBreeds)
       jsontoview.fetchJson(this,urlmaker("ragd"),findViewById(R.id.ragd),findViewById(R.id.textragd),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("mcoo"),findViewById(R.id.mcoo),findViewById(R.id.textmcoo),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("tonk"),findViewById(R.id.tonk),findViewById(R.id.tonktext),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("hima"),findViewById(R.id.hima),findViewById(R.id.himatext),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("asho"),findViewById(R.id.asho),findViewById(R.id.ashotext),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("char"),findViewById(R.id.chara),findViewById(R.id.chartext),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("buri"),findViewById(R.id.buri),findViewById(R.id.buritext),false,urlholderBreeds)
        jsontoview.fetchJson(this,urlmaker("nebe"),findViewById(R.id.nebe),findViewById(R.id.nebetext),false,urlholderBreeds)


        //tonk,hima,asho,chara(char),buri,nebe


        bsho.setOnClickListener({ActivtyMaker("bsho")})
        sphy.setOnClickListener({ActivtyMaker("sphy")})
        tvan.setOnClickListener({ActivtyMaker("tvan")})
        siam.setOnClickListener({ActivtyMaker("siam")})
        pers.setOnClickListener({ActivtyMaker("pers")})
        ragd.setOnClickListener({ActivtyMaker("ragd")})
        mcoo.setOnClickListener({ActivtyMaker("mcoo")})
        tonk.setOnClickListener({ActivtyMaker("tonk")})
        hima.setOnClickListener({ActivtyMaker("hima")})
        asho.setOnClickListener({ActivtyMaker("asho")})
        chara.setOnClickListener({ActivtyMaker("char")})
        buri.setOnClickListener({ActivtyMaker("buri")})
        nebe.setOnClickListener({ActivtyMaker("nebe")})





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

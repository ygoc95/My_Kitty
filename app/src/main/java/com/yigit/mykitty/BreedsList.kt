package com.yigit.mykitty

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_breeds_list.*

class BreedsList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breeds_list)

        Glide.with(this).load(R.drawable.loading).into(bsho)
        Glide.with(this).load(R.drawable.loading).into(sphy)
        Glide.with(this).load(R.drawable.loading).into(tvan)
        Glide.with(this).load(R.drawable.loading).into(pers)
        Glide.with(this).load(R.drawable.loading).into(ragd)
        Glide.with(this).load(R.drawable.loading).into(mcoo)
        Glide.with(this).load(R.drawable.loading).into(tonk)
        Glide.with(this).load(R.drawable.loading).into(hima)
        Glide.with(this).load(R.drawable.loading).into(asho)
        Glide.with(this).load(R.drawable.loading).into(siam)
        Glide.with(this).load(R.drawable.loading).into(chara)
        Glide.with(this).load(R.drawable.loading).into(buri)
        Glide.with(this).load(R.drawable.loading).into(nebe)






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

//enter your key here
       val str="https://api.thecatapi.com/v1/images/search?breed_id="+id+"&api_key="


        return str

    }

}

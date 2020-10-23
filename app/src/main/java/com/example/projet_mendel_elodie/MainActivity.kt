package com.example.projet_mendel_elodie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val andVersionArray = Array<AndVersion>(6, { AndVersion() })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seedItems()

        andVersionRecyclerView.layoutManager = LinearLayoutManager(this)
        andVersionRecyclerView.adapter = AndVersionAdapter(andVersionArray)
    }

    private fun seedItems() {
        var nameArray = resources.getStringArray(R.array.andVersionName)
        val imgArray = intArrayOf(R.drawable.img_cupcake, R.drawable.img_donut, R.drawable.img_eclair, R.drawable.img_froyo, R.drawable.img_honeycomb, R.drawable.img_gingerbread)
        var detailsArray = resources.getStringArray(R.array.andVersionDetails)
        var urlWikiArray = resources.getStringArray(R.array.andVersionURLWiki)
        for (i in 0..nameArray.size - 1)
            andVersionArray[i] = AndVersion(nameArray[i], imgArray[i], detailsArray[i], urlWikiArray[i])
    }
}
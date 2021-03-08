package com.example.pindahactivitydenganintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOBIL = "Extra_Mobil"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_object)

        val tvReceived = findViewById<TextView>(R.id.text_object_receiver)
        val mobil = intent.getParcelableExtra<Mobil>(EXTRA_MOBIL)
        val text = "Merk: ${mobil?.merk.toString()} \nTahun: ${mobil?.tahun}\n Plat: ${mobil?.plat.toString()}"
        tvReceived.text = text
    }
}
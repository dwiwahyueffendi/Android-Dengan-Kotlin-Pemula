package com.example.pindahactivitydenganintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //private lateinit var btnIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //btnIntent = findViewById(R.id.button_intent)

        val btnIntent = findViewById<Button>(R.id.button_intent)
        val btnIntentData = findViewById<Button>(R.id.button_intent_data)

        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_intent -> run{
                val intentBiasa = Intent(this@MainActivity, IntentBiasaActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.button_intent_data -> kotlin.run {
                val intentData = Intent(this@MainActivity, IntentDataActivity::class.java)
                intentData.putExtra(IntentDataActivity.EXTRA_TEXT, "Hai Guyss")
                startActivity(intentData)
            }
        }
    }
}
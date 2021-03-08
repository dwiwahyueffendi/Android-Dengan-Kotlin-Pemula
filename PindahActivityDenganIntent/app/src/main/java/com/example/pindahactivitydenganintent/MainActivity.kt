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
        val btnIntentData2 = findViewById<Button>(R.id.button_intent_data2)
        val btnIntentMoveObject = findViewById<Button>(R.id.button_move_object)

        btnIntent.setOnClickListener(this)
        btnIntentData2.setOnClickListener(this)
        btnIntentMoveObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_intent -> run{
                val intentBiasa = Intent(this@MainActivity, IntentBiasaActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.button_intent_data2 -> run {
                val intentData = Intent(this@MainActivity, IntentDataActivity::class.java)
                intentData.putExtra(IntentDataActivity.EXTRA_TEXT, "Hai Guyss")
                startActivity(intentData)
            }
            R.id.button_move_object -> run{
                val mobil = Mobil(
                    "Toyota Avanza",
                    2012,
                    "L 1200 XL"
                )

                val intentObject = Intent(this@MainActivity, IntentObjectActivity::class.java)
                intentObject.putExtra(IntentObjectActivity.EXTRA_MOBIL, mobil)
                startActivity(intentObject)
            }
        }
    }
}
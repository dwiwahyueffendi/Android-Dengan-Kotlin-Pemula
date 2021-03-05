package com.example.pindahactivitydenganintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentDataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TEXT = "Extra Text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_data)

        val tvReceiver = findViewById<TextView>(R.id.text_penerima_data)
        val textReceived = intent.getStringExtra(EXTRA_TEXT)
        val text = "Text yang di terima adalah $textReceived"
        tvReceiver.text = text
    }
}
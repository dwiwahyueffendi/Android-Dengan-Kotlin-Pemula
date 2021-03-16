package com.example.pindahactivitydenganintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //private lateinit var btnIntent : Button
    private lateinit var tvResult : TextView

    companion object{
        val REQUEST_CODE = 200
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //btnIntent = findViewById(R.id.button_intent)

        val btnIntent = findViewById<Button>(R.id.button_intent)
        val btnIntentData2 = findViewById<Button>(R.id.button_intent_data2)
        val btnIntentMoveObject = findViewById<Button>(R.id.button_move_object)
        val btnIntentImplicit = findViewById<Button>(R.id.btn_implicit)
        val btnIntentFeedback = findViewById<Button>(R.id.btn_pindah_result)
        //val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult = findViewById(R.id.tv_result)

        btnIntent.setOnClickListener(this)
        btnIntentData2.setOnClickListener(this)
        btnIntentMoveObject.setOnClickListener(this)
        btnIntentImplicit.setOnClickListener(this)
        btnIntentFeedback.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if (resultCode == ResultActivity.RESULT_CODE) {
                val nilaiPilih = data?.getIntExtra(ResultActivity.EXTRA_PILIH, 0)
                tvResult.text = "Nilai yang di pilih adalah $nilaiPilih"
            }
        }
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
            R.id.btn_implicit -> kotlin.run {
                val telp = "081515427617"
                val intentImplicit = Intent(Intent.ACTION_VIEW, Uri.parse("tel:$telp") )
                startActivity(intentImplicit)
            }
            R.id.btn_pindah_result -> {
                val intentPindahResult = Intent(this@MainActivity, ResultActivity::class.java)
                startActivityForResult(intentPindahResult, REQUEST_CODE)
            }
        }
    }
}
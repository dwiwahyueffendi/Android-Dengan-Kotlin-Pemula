package com.example.pindahactivitydenganintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rgPilih : RadioGroup

    companion object{
        val RESULT_CODE = 210
        val EXTRA_PILIH = "extra_pilih"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        rgPilih = findViewById(R.id.rg_pilihan)
        //val rgPilihan = findViewById<RadioGroup>(R.id.rg_pilihan)
        val btnResult = findViewById<Button>(R.id.btn_result)

        btnResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_result){
            if(rgPilih.checkedRadioButtonId!=0){
                var nilai = 0
                when(rgPilih.checkedRadioButtonId){
                    R.id.id_1 -> nilai = 1
                    R.id.id_2 -> nilai = 2
                    R.id.id_3 -> nilai = 3
                    R.id.id_4 -> nilai = 4
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_PILIH, nilai)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}
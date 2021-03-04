package com.example.membuataplikasisederhana

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etInput : EditText
    lateinit var btnSubmit : Button
    lateinit var tvOutput : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etInput = findViewById(R.id.et_input)
        btnSubmit = findViewById(R.id.btn_submit)
        tvOutput = findViewById(R.id.tv_output)

        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_submit){
            val isiEditText = etInput.text.toString()
            tvOutput.text = isiEditText
        }
    }
}
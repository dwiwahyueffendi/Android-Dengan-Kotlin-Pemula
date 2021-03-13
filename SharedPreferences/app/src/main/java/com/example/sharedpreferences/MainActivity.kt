package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var profilPref: ProfilPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profilPref = ProfilPref(this)

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvAge = findViewById<TextView>(R.id.tv_age)
        val tvGender = findViewById<TextView>(R.id.tv_gender)

        if (profilPref.preference.contains(ProfilPref.NAME)){
            val profile = profilPref.getProfile()
            tvName.text = profile.name
            tvAge.text = profile.age.toString()
            tvGender.text = profile.gender
        }

        val btnEditData = findViewById<Button>(R.id.btn_edit)
        btnEditData.setOnClickListener {
            Intent(this, FormActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FormActivity : AppCompatActivity() {

    lateinit var profilePref: ProfilPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val etName = findViewById<TextView>(R.id.et_name)
        val etAge = findViewById<TextView>(R.id.et_age)
        val etGender = findViewById<TextView>(R.id.et_gender)
        val btnSave = findViewById<Button>(R.id.btn_save)

        profilePref = ProfilPref(this)

        if(profilePref.preference.contains(ProfilPref.NAME)){
            val profile = profilePref.getProfile()
            etName.setText(profile.name)
            profile.age?.let { etAge.setText(it.toString()) }
            etGender.setText(profile.gender)
        }

        btnSave.setOnClickListener{
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val gender = etGender.text.toString().trim()

            val profile = dataProfile(
                name,
                age.toInt(),
                gender
            )

            saveToPref(profile)
        }
    }

    private fun saveToPref(profile: dataProfile) {
        profilePref.setProfile(profile)
        Toast.makeText(this, "Data Berhasil Di Simpan", Toast.LENGTH_SHORT).show()
        Intent(this, MainActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}
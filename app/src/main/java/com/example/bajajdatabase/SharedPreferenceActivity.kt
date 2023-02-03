package com.example.bajajdatabase

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bajajdatabase.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {

    lateinit var myLayout : ActivitySharedPreferenceBinding
    lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        myLayout = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(myLayout.root)

        sp = getSharedPreferences("myfile", MODE_PRIVATE)

        myLayout.editText.setText(sp.getString("un",""))

        myLayout.button.setOnClickListener {

            var username = myLayout.editText.text.toString()
            var editor = sp.edit()
            editor.putString("un",username)
            editor.commit()
        }

    }
}
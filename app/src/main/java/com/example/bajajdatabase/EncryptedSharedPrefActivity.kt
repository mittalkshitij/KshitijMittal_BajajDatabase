package com.example.bajajdatabase

import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.MasterKeys
import com.example.bajajdatabase.databinding.ActivityEncryptedSharedPrefBinding

class EncryptedSharedPrefActivity : AppCompatActivity() {

    lateinit var layout : ActivityEncryptedSharedPrefBinding

    var sharedPreferences : SharedPreferences? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypted_shared_pref)

        layout = ActivityEncryptedSharedPrefBinding.inflate(layoutInflater)
        setContentView(layout.root)


        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)


        sharedPreferences = EncryptedSharedPreferences.create(
            "preferences",
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        layout.passwordEditText.setText(sharedPreferences?.getString("eun",""))

        layout.saveButton.setOnClickListener {

                   var password = layout.passwordEditText.text.toString()
                   Log.i("username", password)
                   var editor = sharedPreferences?.edit()
                   editor?.putString("eun", password)
                   editor?.apply()

           }




    }
}
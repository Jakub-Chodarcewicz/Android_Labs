package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding.button.setOnClickListener{
            val name= binding.editTextText.text.toString()
            binding.textView.text="Podano imie i nazwisko $name"
            Toast.makeText(applicationContext,"Podano imię i nazwisko $name",Toast.LENGTH_SHORT).show()
            Log.d("","Podano imie i nazwisko $name")
        }

    }
}

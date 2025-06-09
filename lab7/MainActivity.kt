package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val input = binding.inputText.text.toString().trim()


        binding.proceedButton.setOnClickListener {
            val input = binding.inputText.text.toString().trim()

            if (input.isNotEmpty()) {
                val fullText = input
                val intent = Intent(this, ActivityA::class.java)
                intent.putExtra("text", fullText)
                startActivity(intent)
            }
        }
    }
}

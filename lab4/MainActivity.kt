package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import kotlin.random.Random
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val activities = listOf(
        "Spacer",
        "Czytanie książki",
        "Siłownia",
        "Gotowanie",
        "Drzemka",
        "Sprzątanie",
        "Oglądanie filmu",
        "Zakupy"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.drawButton.setOnClickListener {
            Toast.makeText(this, "Kliknąłeś wybór dzisiejszej czynnosci! \n Trwa losowanie czynności...", Toast.LENGTH_SHORT).show()

            // Opóźnienie 1.5 sekundy (1500 ms)
            binding.drawButton.postDelayed({
                val randomActivity = activities.random()
                binding.resultText.text = "Wybrałeś: $randomActivity!"
            }, 1500)
        }

    }
}

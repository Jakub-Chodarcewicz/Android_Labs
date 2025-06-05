package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "BMICalculator"
    private fun showLifecycleMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        Log.d(TAG, message)
    }

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

        binding.calculateButton.setOnClickListener {
            val weightText = binding.weightInput.text.toString()
            val heightText = binding.heightInput.text.toString()

            if (weightText.isBlank() || heightText.isBlank()) {
                Toast.makeText(this, "Wprowadź wagę i wzrost", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val weight = weightText.toFloatOrNull()
            val heightCm = heightText.toFloatOrNull()

            if (weight == null || heightCm == null || weight <= 0 || heightCm <= 0) {
                Toast.makeText(this, "Nieprawidłowe dane", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val heightM = heightCm / 100
            val bmi = weight / (heightM * heightM)

            val category = when {
                bmi < 18.5 -> "Niedowaga"
                bmi < 25 -> "Prawidłowa masa ciała"
                bmi < 30 -> "Nadwaga"
                bmi < 35 -> "Otyłość I stopnia"
                bmi < 40 -> "Otyłość II stopnia"
                else -> "Otyłość III stopnia"
            }

            val result = String.format("Twoje BMI: %.2f\nKategoria: %s", bmi, category)

            binding.resultText.text = result
            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            Log.d(TAG, result)
        }
    }

    override fun onStart() {
        super.onStart()
        showLifecycleMessage("onStart: aplikacja widoczna")
    }

    override fun onResume() {
        super.onResume()
        showLifecycleMessage("onResume: aplikacja aktywna")
    }

    override fun onPause() {
        super.onPause()
        showLifecycleMessage("onPause: aplikacja częściowo niewidoczna")
    }

    override fun onStop() {
        super.onStop()
        showLifecycleMessage("onStop: aplikacja niewidoczna")
    }
    override fun onDestroy() {
        super.onDestroy()
        showLifecycleMessage("onDestroy: aplikacja zniszczona")
    }

    override fun onRestart() {
        super.onRestart()
        showLifecycleMessage("onRestart: aplikacja ponownie uruchomiona")
    }

}

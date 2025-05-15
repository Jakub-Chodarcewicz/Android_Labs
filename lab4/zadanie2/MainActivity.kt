package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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

        binding.flipButton.setOnClickListener {
            Toast.makeText(this, "Rzucasz monetą...", Toast.LENGTH_SHORT).show()

            binding.flipButton.postDelayed({
                val result1 = Random.nextBoolean()
                val result2 = Random.nextBoolean()
                val resultText1 = if (result1) "orzeł" else "reszka"
                val resultText2 = if (result2) "orzeł" else "reszka"
                        binding.resultText.text = "Moneta 1: $resultText1\nMoneta 2: $resultText2"
                binding.coinImage1.setImageResource(
                    if (result1) R.drawable.orzel else R.drawable.reszka
                )
                binding.coinImage2.setImageResource(
                    if (result2) R.drawable.orzel else R.drawable.reszka
                )

            }, 1000)
            binding.coinImage1.animate().apply {
                duration = 200
                rotationXBy(900f)
            }.withEndAction{
                binding.coinImage1.animate().apply {
                    duration=200
                    rotationXBy(900f)
                }
            }.start()
            binding.coinImage2.animate().apply {
                duration = 200
                rotationXBy(900f)
            }.withEndAction{
                binding.coinImage2.animate().apply {
                    duration=200
                    rotationXBy(900f)
                }
            }.start()
        }
    }
}

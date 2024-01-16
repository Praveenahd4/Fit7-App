package com.fit7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fit7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.flStart?.setOnClickListener {
            val intent = Intent(this,WorkoutActivity::class.java)
            startActivity(intent)
        }
        binding?.flBMI?.setOnClickListener {
            // Launching the BMI Activity
            val intent = Intent(this, BmiCalculationActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
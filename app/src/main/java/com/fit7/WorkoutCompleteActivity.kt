package com.fit7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fit7.databinding.ActivityWorkoutCompleteBinding

class WorkoutCompleteActivity : AppCompatActivity() {
    private var binding: ActivityWorkoutCompleteBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutCompleteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarFinishActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnFinish?.setOnClickListener {
            finish()
        }
    }
}
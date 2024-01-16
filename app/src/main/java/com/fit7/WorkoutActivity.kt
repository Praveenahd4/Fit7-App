package com.fit7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fit7.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {


    private var restTimer: CountDownTimer? = null
    private var restProgress = 0


    private var workoutTimer: CountDownTimer? = null
    private var workoutProgress = 0

    private var workoutTimerDuration: Long = 30
    private var workoutList: ArrayList<WorkoutModel>? = null
    private var currentWorkoutPosition = -1

    private var workoutAdapter: ExerciseStatusAdapter? = null

    private var binding: ActivityWorkoutBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarWorkout)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarWorkout?.setNavigationOnClickListener {
            onBackPressed()
        }
        workoutList = Constants.defaultExerciseList()
        setupRestView()
        setupExerciseStatusRecyclerView()
    }


    private fun setupRestView() {

        binding?.flRestView?.visibility = View.VISIBLE
        binding?.tvTitle?.visibility = View.VISIBLE
        binding?.upcomingLabel?.visibility = View.VISIBLE
        binding?.tvUpcomingExerciseName?.visibility = View.VISIBLE
        binding?.tvExerciseName?.visibility = View.INVISIBLE
        binding?.flExerciseView?.visibility = View.INVISIBLE
        binding?.ivImage?.visibility = View.INVISIBLE

        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        binding?.tvUpcomingExerciseName?.text =
            workoutList!![currentWorkoutPosition + 1].getName()
        setRestProgressBar()
    }

    private fun setRestProgressBar() {

        binding?.progressBar?.progress = restProgress

        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text =
                    (10 - restProgress).toString()
            }

            override fun onFinish() {
                currentWorkoutPosition++

                workoutList!![currentWorkoutPosition].setIsSelected(true)
                workoutAdapter!!.notifyDataSetChanged()
                setupExerciseView()

                setupExerciseView()
            }
        }.start()
    }

    private fun setupExerciseView() {


        binding?.flRestView?.visibility = View.INVISIBLE
        binding?.tvTitle?.visibility = View.INVISIBLE
        binding?.tvUpcomingExerciseName?.visibility = View.INVISIBLE
        binding?.upcomingLabel?.visibility = View.INVISIBLE
        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding?.flExerciseView?.visibility = View.VISIBLE
        binding?.ivImage?.visibility = View.VISIBLE


        if (workoutTimer != null) {
            workoutTimer?.cancel()
            workoutProgress = 0
        }

        binding?.ivImage?.setImageResource(workoutList!![currentWorkoutPosition].getImage())
        binding?.tvExerciseName?.text = workoutList!![currentWorkoutPosition].getName()


        setExerciseProgressBar()
    }


    private fun setExerciseProgressBar() {

        binding?.progressBarExercise?.progress = workoutProgress

        workoutTimer = object : CountDownTimer(workoutTimerDuration * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                workoutProgress++
                binding?.progressBarExercise?.progress =
                    workoutTimerDuration.toInt() - workoutProgress
                binding?.tvTimerExercise?.text =
                    (workoutTimerDuration.toInt() - workoutProgress).toString()
            }

            override fun onFinish() {
                if (currentWorkoutPosition < workoutList?.size!! - 1) {

                    workoutList!![currentWorkoutPosition].setIsSelected(false)
                    workoutList!![currentWorkoutPosition].setIsCompleted(true)
                    setupRestView()
                } else {
                    finish()
                    val intent = Intent(this@WorkoutActivity, WorkoutCompleteActivity::class.java)
                    startActivity(intent)

                }
            }
        }.start()
    }

    public override fun onDestroy() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        super.onDestroy()
        binding = null
    }

    private fun setupExerciseStatusRecyclerView() {
        binding?.rvExerciseStatus?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        workoutAdapter = ExerciseStatusAdapter(workoutList!!)

        binding?.rvExerciseStatus?.adapter = workoutAdapter
    }

}
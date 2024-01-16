package com.fit7

import java.util.ArrayList

object Constants {
    fun defaultExerciseList(): ArrayList<WorkoutModel> {

        val exerciseList = ArrayList<WorkoutModel>()

        val jumpingJacks =
            WorkoutModel(
                1, "Jumping Jacks",
                R.drawable.ic_jumping_jacks, false, false
            )
        exerciseList.add(jumpingJacks)

        val wallSit = WorkoutModel(
            2, "Wall Sit",
            R.drawable.ic_wall_sit, false, false
        )
        exerciseList.add(wallSit)

        val pushUp = WorkoutModel(
            3, "Push Up",
            R.drawable.ic_push_up, false, false
        )
        exerciseList.add(pushUp)

        val abdominalCrunch =
            WorkoutModel(
                4, "Abdominal Crunch",
                R.drawable.ic_abdominal_crunch, false, false
            )
        exerciseList.add(abdominalCrunch)

        val stepUpOnChair =
            WorkoutModel(
                5, "Step-Up onto Chair",
                R.drawable.ic_step_up_onto_chair,
                false,
                false
            )
        exerciseList.add(stepUpOnChair)

        val squat = WorkoutModel(
            6, "Squat",
            R.drawable.ic_squat, false, false
        )
        exerciseList.add(squat)

        val tricepDipOnChair =
            WorkoutModel(
                7,
                "Tricep Dip On Chair",
                R.drawable.ic_triceps_dip_on_chair,
                false,
                false
            )
        exerciseList.add(tricepDipOnChair)

        val plank = WorkoutModel(
            8, "Plank",
            R.drawable.ic_plank, false, false
        )
        exerciseList.add(plank)

        val highKneesRunningInPlace =
            WorkoutModel(
                9, "High Knees Running In Place",
                R.drawable.ic_high_knees_running_in_place,
                false,
                false
            )
        exerciseList.add(highKneesRunningInPlace)

        val lunges = WorkoutModel(
            10, "Lunges",
            R.drawable.ic_lunge, false, false
        )
        exerciseList.add(lunges)

        val pushupAndRotation =
            WorkoutModel(
                11,
                "Push up and Rotation",
                R.drawable.ic_push_up_and_rotation,
                false,
                false
            )
        exerciseList.add(pushupAndRotation)

        val sidePlank = WorkoutModel(
            12, "Side Plank",
            R.drawable.ic_side_plank, false, false
        )
        exerciseList.add(sidePlank)

        return exerciseList
    }
}
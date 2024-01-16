package com.fit7

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fit7.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(private val items: ArrayList<WorkoutModel>) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExerciseStatusBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model: WorkoutModel = items[position]

        holder.tvItem.text = model.getId().toString()
        when {
            model.getIsSelected() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.item_circle
                    )
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }

            model.getIsCompleted() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.item_circular_color_accent_background
                    )
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }

            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(
                        holder.itemView.context,
                        R.drawable.item_circular_color_gray_background
                    )
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(binding: ItemExerciseStatusBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }
}
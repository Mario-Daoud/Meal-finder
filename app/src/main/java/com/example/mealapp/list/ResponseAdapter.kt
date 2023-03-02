package com.example.mealapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealapp.databinding.ItemInListBinding
import com.example.mealapp.models.Meal

class MealAdapter(val clickListener: MealClickListener): ListAdapter<Meal, MealAdapter.ViewHolder>(MealDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: ItemInListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            meal: Meal,
            clickListener: MealClickListener
        ) {
            // meal + clicklistener declaration
            binding.meal = meal
            binding.clickListener = clickListener

            binding.executePendingBindings()

            // image
            Glide.with(binding.root.context)
                .load(meal.strMealThumb)
                .into(binding.ivMealImage)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemInListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class MealDiffCallback : DiffUtil.ItemCallback<Meal>() {

    // check items same or not
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    // content identical?
    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }
}

// when clicking on item
class MealClickListener(val clickListener: (meal: Meal) -> Unit) {
    fun onClick(meal: Meal) = clickListener(meal)
}

package com.example.mealapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealapp.models.Meal

class DetailViewModelFactory(val meal: Meal) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(meal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
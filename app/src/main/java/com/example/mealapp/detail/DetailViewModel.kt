package com.example.mealapp.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealapp.models.Meal

class DetailViewModel(val __meal: Meal) : ViewModel() {

    // meal for clicking
    private var _meal = MutableLiveData<Meal>()
    val meal : LiveData<Meal>
    get() {
        return _meal
    }

    init {
        _meal.value = __meal
    }

}
package com.example.mealapp.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealapp.network.MealApi
import com.example.mealapp.models.Meal
import com.example.mealapp.models.MealBase
import kotlinx.coroutines.launch

class MealListViewModel : ViewModel() {

    // entered letter + error + meal + mealbase(meal list) field
    var enteredLetter = MutableLiveData<String>()
    var error = MutableLiveData<String?>()

    private var _meal = MutableLiveData<Meal?>()
    val meal: LiveData<Meal?>
        get() {
            return _meal
        }

    private var _mealBase = MutableLiveData<MealBase?>()
    val mealBase: LiveData<MealBase?>
        get() {
            return _mealBase
        }

    init {
        enteredLetter.value = ""
    }

    // when clicking on search button
    fun onSearchButtonClicked() {
        // if empty
        if (enteredLetter.value.isNullOrBlank()) {
            error.value = "You can't search for meals without entering a letter."
        }
        // if not 1 letter
        else if (enteredLetter.value?.length!! > 1) {
            error.value = "Entered text can only be 1 character."
        } else {
            error.value = null
            // fill recyclerview
            viewModelScope.launch {
                try {
                    _mealBase.value  = MealApi.retrofitService.getMealsByLetter(enteredLetter.value!!)
                } catch (e: Exception) {
                    error.value = "No meals Found."
                }
            }
        }
    }

    // onclick
    fun onMealClicked(meal: Meal) {
        navigateToMealDetail(meal)
        navigateToDetailFinished()
    }

    // navigate to detail
    fun navigateToMealDetail(meal: Meal) {
        _meal.value = meal
    }

    // navigate finished
    fun navigateToDetailFinished() {
        _meal.value = null
        enteredLetter.value = ""
        _mealBase.value = null
    }


}
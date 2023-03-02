package com.example.mealapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// list of meals
data class MealBase(
    val meals: List<Meal>
    )

// meal model
@Parcelize
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String
    ): Parcelable

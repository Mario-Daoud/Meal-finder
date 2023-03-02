package com.example.mealapp.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealapp.UserSingleton

class MainViewModel : ViewModel(){

    // error fields
    var loginError = MutableLiveData<String?>()
    var errorPassword = MutableLiveData<String?>()

    // edit text fields
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    // navigate
    private val _navigateToRecyclerList = MutableLiveData<Boolean>()
    val navigateToRecyclerList : LiveData<Boolean>
        get() {
            return _navigateToRecyclerList
        }

    init {
        username.value=""
        password.value=""
        _navigateToRecyclerList.value = false
    }

    // navigate finished after navigation fields empty
    fun navigateFinished() {
        username.value=""
        password.value=""
        _navigateToRecyclerList.value = false
    }

    // on click login button succes
    fun navigateToRecyclerList() {
        _navigateToRecyclerList.value = true
    }

    // on login button click checks
    fun btnLoginClicked() {

        // if username empty
        if (username.value.isNullOrBlank()) {
            loginError.value = "Username can not be empty!"
        }
        else {
            loginError.value = null
        }
        // if password empty
        if (password.value.isNullOrBlank()) {
            errorPassword.value = "Password can not be empty!"
        } else  {
            errorPassword.value = null
        }

        // no errors? login if user found
        if (errorPassword.value.isNullOrBlank() && loginError.value.isNullOrBlank()) {
            val foundUser = UserSingleton.getInstance().users.find { it.username == username.value && it.password == password.value }
            if (foundUser != null) {
                navigateToRecyclerList()
            } else {
                loginError.value = "User not found"
            }
        }

    }

}
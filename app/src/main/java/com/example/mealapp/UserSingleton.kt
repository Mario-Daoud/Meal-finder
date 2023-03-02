package com.example.mealapp

class UserSingleton private constructor() {

    // users login
    val users = arrayOf(
        User("admin", "admin"),
        User("dirkh", "Dirk123"),
        User("mario", "M123!")
    )

    // get singleton
    companion object {
        private var instance: UserSingleton? = null
        // get users
        fun getInstance(): UserSingleton {
            if (instance == null) {
                instance = UserSingleton()
            }
            return instance!!
        }
    }
}

// user model
data class User(val username: String, val password: String)

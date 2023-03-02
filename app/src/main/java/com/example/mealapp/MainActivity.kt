package com.example.mealapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mealapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
    }
}
package com.example.typing_tracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.typing_tracker.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Typing_Tracker)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
package com.example.typing_tracker.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir)
}

package com.example.typing_tracker.ui.statistics.speed

import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentSpeedBinding
import com.example.typing_tracker.ui.base.BaseFragment

class SpeedFragment: BaseFragment<FragmentSpeedBinding, SpeedViewModel>() {

    override val layoutId = R.layout.fragment_speed
    override val viewModelClass = SpeedViewModel::class.java

    override fun observeEvents() {
    }

    override fun setUpBinding() {
    }
}
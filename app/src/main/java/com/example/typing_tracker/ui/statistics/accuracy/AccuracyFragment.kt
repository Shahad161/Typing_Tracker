package com.example.typing_tracker.ui.statistics.accuracy

import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentAccuracyBinding
import com.example.typing_tracker.ui.base.BaseFragment

class AccuracyFragment: BaseFragment<FragmentAccuracyBinding, AccuracyViewModel>() {

    override val layoutId = R.layout.fragment_accuracy
    override val viewModelClass = AccuracyViewModel::class.java

    override fun observeEvents() {
    }

    override fun setUpBinding() {
    }
}
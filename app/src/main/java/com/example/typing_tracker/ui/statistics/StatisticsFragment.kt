package com.example.typing_tracker.ui.statistics


import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStatisticsBinding
import com.example.typing_tracker.ui.base.BaseFragment

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>(){

    override val layoutId: Int = R.layout.fragment_statistics
    override val viewModelClass = StatisticsViewModel::class.java

    override fun observeEvents() {

    }

    override fun setUpBinding() {

    }


}
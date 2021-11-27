package com.example.typing_tracker.ui.statistics

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class StatisticsPagerAdapter(container: Fragment, private val fragmentsList: List<Fragment>)
    : FragmentStateAdapter(container) {

    override fun getItemCount() = fragmentsList.size

    override fun createFragment(position: Int) = fragmentsList[position]
}
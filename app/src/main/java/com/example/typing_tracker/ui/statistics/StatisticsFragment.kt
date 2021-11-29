package com.example.typing_tracker.ui.statistics


import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStatisticsBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.ui.statistics.accuracy.AccuracyFragment
import com.example.typing_tracker.ui.statistics.speed.SpeedFragment
import com.example.typing_tracker.util.goToFragment
import com.example.typing_tracker.util.observeEvent
import com.google.android.material.tabs.TabLayoutMediator

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding, StatisticsViewModel>(){

    private val fragmentsList = listOf(SpeedFragment(), AccuracyFragment())
    private val tabTitles = listOf("Speed", "Accuracy")

    override val layoutId: Int = R.layout.fragment_statistics
    override val viewModelClass = StatisticsViewModel::class.java

    override fun observeEvents() {

        viewModel.clickBackButton.observeEvent(this){
            view?.goToFragment(StatisticsFragmentDirections.actionStatisticsFragmentToStartFragment())
        }

    }

    override fun setUpBinding() {
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        binding.viewPager.apply {
            adapter = StatisticsPagerAdapter(this@StatisticsFragment, fragmentsList)
            isUserInputEnabled = false
        }
    }


}
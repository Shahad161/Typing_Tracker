package com.example.typing_tracker.ui.home

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentHomeBinding
import com.example.typing_tracker.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(){

    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java

    val chosenDifficulty : HomeFragmentArgs by navArgs()

    override fun observeEvents() {

    }

    override fun setUpBinding() {
        binding.countUpTimer.start()
    }

    fun navigateToStatistics() {
        val action = HomeFragmentDirections.actionHomeFragmentToStatisticsFragment()
        findNavController().navigate(action)
    }


}
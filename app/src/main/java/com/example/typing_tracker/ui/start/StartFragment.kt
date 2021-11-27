package com.example.typing_tracker.ui.start

import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStartBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.EventObserver
import com.example.typing_tracker.util.goToFragment
import com.example.typing_tracker.util.observeEvent


class StartFragment  : BaseFragment<FragmentStartBinding, StartViewModel>(){

    override val layoutId: Int = R.layout.fragment_start
    override val viewModelClass = StartViewModel::class.java


    override fun observeEvents() {
        viewModel.clickStart.observeEvent(this) { level ->
            view?.goToFragment(StartFragmentDirections.actionStartFragmentToHomeFragment(level!!))
        }
    }

    override fun setUpBinding() {
        binding.statsticsImageView.setOnClickListener {
            view?.goToFragment(StartFragmentDirections.actionStartFragmentToStatisticsFragment())
        }
    }


}
package com.example.typing_tracker.ui.start

import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStartBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.EventObserver
import com.example.typing_tracker.util.goToFragment


class StartFragment  : BaseFragment<FragmentStartBinding, StartViewModel>(){

    override val layoutId: Int = R.layout.fragment_start
    override val viewModelClass = StartViewModel::class.java


    override fun observeEvents() {
        viewModel.gameConfigurationEvent.observe(this , EventObserver {
            binding.startBtn.goToFragment(
                StartFragmentDirections.actionStartFragmentToHomeFragment(it!!)
            )
        })
    }

    override fun setUpBinding() {
    }


}
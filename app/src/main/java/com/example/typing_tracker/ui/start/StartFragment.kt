package com.example.typing_tracker.ui.start

import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStartBinding
import com.example.typing_tracker.ui.base.BaseFragment


class StartFragment  : BaseFragment<FragmentStartBinding, StartViewModel>(){

    override val layoutId: Int = R.layout.fragment_start
    override val viewModelClass = StartViewModel::class.java


    override fun observeEvents() {
    }

    override fun setUpBinding() {
    }


}
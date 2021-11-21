package com.example.typing_tracker.ui.history


import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentHistoryBinding
import com.example.typing_tracker.ui.base.BaseFragment

class HistoryFragment : BaseFragment<FragmentHistoryBinding, HistoryViewModel>(){

    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HistoryViewModel::class.java

    override fun observeEvents() {

    }

    override fun setUpBinding() {

    }


}
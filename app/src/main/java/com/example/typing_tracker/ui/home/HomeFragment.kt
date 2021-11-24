package com.example.typing_tracker.ui.home

import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentHomeBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.Constants
import com.example.typing_tracker.util.Difficulty


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(){

    override val layoutId: Int = R.layout.fragment_home
    override val viewModelClass = HomeViewModel::class.java
    private val args: HomeFragmentArgs by navArgs()


    override fun observeEvents() {

    }

    override fun setUpBinding() {
        viewModel.getParagraph(args.level)
        binding.countUpTimer.start()
    }


}
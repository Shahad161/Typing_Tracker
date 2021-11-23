package com.example.typing_tracker.ui.start


import androidx.navigation.fragment.findNavController
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentStartBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.*


class StartFragment : BaseFragment<FragmentStartBinding, StartViewModel>() {

    override val layoutId: Int = R.layout.fragment_start
    override val viewModelClass = StartViewModel::class.java


    override fun observeEvents() {
        viewModel.difficulty.observe(this, EventObserver { difficulty ->
            navigateToHome(difficulty)
        })

    }

    fun navigateToHome(difficulty: Difficulty) {
        val action = StartFragmentDirections.actionStartFragmentToHomeFragment(difficulty)
        findNavController().navigate(action)
    }

    override fun setUpBinding() {
        binding.startButton.setOnClickListener {
                viewModel.onClickStartGame(binding.itemSpinner.selectedItem.toString())
            }

    }


}
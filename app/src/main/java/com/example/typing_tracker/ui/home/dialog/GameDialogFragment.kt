package com.example.typing_tracker.ui.home.dialog

import androidx.navigation.fragment.findNavController
import com.example.typing_tracker.R
import com.example.typing_tracker.databinding.FragmentGameDialogBinding
import com.example.typing_tracker.ui.base.BaseFragment
import com.example.typing_tracker.util.Difficulty
import com.example.typing_tracker.util.observeEvent


class GameDialogFragment: BaseFragment<FragmentGameDialogBinding, GameDialogModelView>() {

    override val layoutId = R.layout.fragment_game_dialog
    override val viewModelClass = GameDialogModelView::class.java

    override fun observeEvents() {
        viewModel.navigateToStatistics.observeEvent(this){
            navigateToStatistics()
        }

        viewModel.navigateToGame.observeEvent(this){
            navigateToGame()
        }
    }

    override fun setUpBinding() {
    }

    private fun navigateToGame() {
        findNavController().navigate(GameDialogFragmentDirections.actionGameDialogFragmentToHomeFragment(Difficulty.EASY))
    }

    private fun navigateToStatistics() {
        val action = GameDialogFragmentDirections.actionGameDialogFragmentToStatisticsFragment()
        findNavController().navigate(action)
    }

}